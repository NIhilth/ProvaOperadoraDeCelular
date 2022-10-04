package controller;

import model.entities.Operadora;
import model.entities.Plano;
import model.service.PlanoService;

import java.util.ArrayList;

/**
 * Classe de entrada para a view, passando as ações executadas para a service fazer
 * a requisição
 */
public class PlanoController {
    PlanoService planoService = new PlanoService();

    public void cadastrar(Plano plano){
        planoService.cadastrar(plano);
    }

    public ArrayList<Plano> listarTodos(){
        return planoService.listarTodos();
    }

    public ArrayList<Plano> listarPorOperadora(Operadora operadora){
        return planoService.listarPorOperadora(operadora);
    }

    public Plano selecionarPlano(int idPlano){
        return planoService.selecionarPlano(idPlano);
    }

    public void deletar(int idPlano){
        planoService.deletar(idPlano);
    }

    public void editar(int idPlano, Plano novoPlano){ planoService.editar(idPlano, novoPlano);}
}
