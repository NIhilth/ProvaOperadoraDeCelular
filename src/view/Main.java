package view;

import controller.PlanoController;
import model.entities.Operadora;
import model.entities.Plano;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe executável da aplicação para operadoras de telecomunicação podendo cadastrar
 * um novo plano, listar todos os planos existentes, listar os planos de uma operadora,
 * consultar um plano expecífico remover um plano existente e editar um plano existente
 *
 * @author joao_hm_silva
 * @version 1.0.0
 */
public class Main {
    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int escolha;

        do{
            System.out.println("-----MENU----");
            System.out.println("""
                    1 - Cadastrar novo plano\s
                    2 - Listar todos os planos\s
                    3 - Listar os planos de uma operadora\s
                    4 - Consultar um plano\s
                    5 - Remover um plano existente\s
                    6 - Editar um plano\s
                    7 - Sair do sistema""");
            escolha = sc.nextInt();

            switch(escolha){
                case 1 -> cadastrar();
                case 2 -> listar(true);
                case 3 -> listar(false);
                case 4 -> consultar();
                case 5 -> deletar();
                case 6 -> editar();
                case 7 -> System.out.println("Finalizando o sistema");
                default -> System.out.println("Opção inválida");
            }
        } while(escolha != 7);

        System.exit(0);
    }

    private static void editar() {
        System.out.println("-----EDIÇÃO-----");
        int idPlano = escolherID();

        Plano novoPlano = montarPlano();
        try{
            PlanoController planoController = new PlanoController();
            planoController.editar(idPlano, novoPlano);
            System.out.println("Edição completa!");
        } catch (RuntimeException exception){
            System.out.println(exception.getMessage());
        }
    }

    private static void deletar() {
        System.out.println("-----REMOÇÃO-----");
        int idPlano = escolherID();

        try{
            PlanoController planoController = new PlanoController();
            planoController.deletar(idPlano);
            System.out.println("Remoção completa!");
        } catch (RuntimeException exception){
            System.out.println(exception.getMessage());
        }
    }

    private static void consultar() {
        System.out.println("-----CONSULTA-----");
        int idPlano = escolherID();
        try {
            PlanoController planoController = new PlanoController();
            System.out.println(planoController.selecionarPlano(idPlano));
            System.out.println("Consulta completa!");
        } catch (RuntimeException exception){
            System.out.println(exception.getMessage());
        }
    }

    private static void listar(boolean todos) {
        System.out.println("-----LISTAGEM-----");
        ArrayList<Plano> listaPlanos;
        try {
            PlanoController planoController = new PlanoController();
            if (todos) {
                listaPlanos = planoController.listarTodos();
            } else {
                String operadora;
                System.out.println("Operadora:\n");
                for (Operadora valoresOperadora : Operadora.values()) {
                    System.out.println(valoresOperadora.getNome());
                }
                System.out.println("\nDigite extamente qual deseja!");
                do {
                    operadora = sc.next();
                    if(!(operadora.equals("VIVO")) && !(operadora.equals("TIM")) && !(operadora.equals("OI")) && !(operadora.equals("CLARO"))){
                        System.out.println("Opção inválida");
                    }
                } while (!(operadora.equals("VIVO")) && !(operadora.equals("TIM")) && !(operadora.equals("OI")) && !(operadora.equals("CLARO")));


                listaPlanos = planoController.listarPorOperadora(Operadora.valueOf(operadora));
            }

            for(Plano plano : listaPlanos){
                System.out.println(plano);
            }
            System.out.println("Listagem concluída");
        } catch (RuntimeException exception){
            System.out.println(exception.getMessage());
        }
    }

    private static void cadastrar(){
        System.out.println("-----CADASTRO-----");
        Plano plano = montarPlano();
        try {
            PlanoController planoController = new PlanoController();
            planoController.cadastrar(plano);
            System.out.println("Cadastro completo!");
        } catch (RuntimeException exception){
            System.out.println(exception.getMessage());
        }
    }

    private static int escolherID() {
        System.out.println("Informe o id do plano desejado:");
        return sc.nextInt();
    }

    private static Plano montarPlano() {
        int opcao, qtdDadosBonus = 0;
        String operadora;
        System.out.println("Operadora:\n");
        for (Operadora valoresOperadora : Operadora.values()) {
            System.out.println(valoresOperadora.getNome());
        }
        System.out.println("\nDigite extamente qual deseja!");
        do {
            operadora = sc.next();
            if(!(operadora.equals("VIVO")) && !(operadora.equals("TIM")) && !(operadora.equals("OI")) && !(operadora.equals("CLARO"))){
                System.out.println("Opção inválida");
            }
        } while (!(operadora.equals("VIVO")) && !(operadora.equals("TIM")) && !(operadora.equals("OI")) && !(operadora.equals("CLARO")));

        sc.nextLine();
        System.out.println("Nome:");
        String nome = sc.nextLine();

        System.out.println("Quantidade de dados:");
        int qtdDados = sc.nextInt();

        do{
            System.out.println("Quantidade bônus de dados?\n1 - Sim \n2 - Não");
            opcao = sc.nextInt();
            if(opcao != 1 && opcao != 2){
                System.out.println("Opção inválida");
            } else if (opcao == 1){
                System.out.println("Quantidade de dados bônus:");
                qtdDadosBonus = sc.nextInt();
            }
        }while(opcao != 1 && opcao != 2);

        sc.nextLine();
        System.out.println("Benefícios:");
        String beneficios = sc.nextLine();

        System.out.println("Valor:");
        double valor = sc.nextDouble();

        return new Plano(qtdDados, Operadora.valueOf(operadora), nome, beneficios, valor, qtdDadosBonus);
    }
}
