package model.entities;

/**
 * Classe para moldar os atributos básicos de um plano de uma telefonia
 * e seus construtores para todas as etapas do processo
 */
public class Plano {
    private Integer idPlano, quantidadeDados, quantidadeDadosBonus = 0;
    private Operadora operadora;
    private String nome, beneficio;
    private Double valor;

    public Plano(Integer idPlano, Integer quantidadeDados, Operadora operadora, String nome, String beneficio, Double valor, Integer quantidadeDadosBonus) {
        this.idPlano = idPlano;
        this.quantidadeDados = quantidadeDados;
        this.quantidadeDadosBonus = quantidadeDadosBonus;
        this.operadora = operadora;
        this.nome = nome;
        this.beneficio = beneficio;
        this.valor = valor;
    }

    public Plano(Integer quantidadeDados, Operadora operadora, String nome, String beneficio, Double valor, Integer quantidadeDadosBonus) {
        this.quantidadeDados = quantidadeDados;
        this.quantidadeDadosBonus = quantidadeDadosBonus;
        this.operadora = operadora;
        this.nome = nome;
        this.beneficio = beneficio;
        this.valor = valor;
    }

    public Plano(Integer idPlano, Integer quantidadeDados, Operadora operadora, String nome, Double valor) {
        this.idPlano = idPlano;
        this.quantidadeDados = quantidadeDados;
        this.operadora = operadora;
        this.nome = nome;
        this.valor = valor;
    }

    public Integer getQuantidadeDados() {
        return quantidadeDados;
    }

    public Integer getQuantidadeDadosBonus() {
        return quantidadeDadosBonus;
    }

    public Operadora getOperadora() {
        return operadora;
    }

    public String getNome() {
        return nome;
    }

    public String getBeneficio() {
        return beneficio;
    }

    public Double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        if(this.beneficio == null){
            return "Plano{" +
                    "idPlano=" + idPlano +
                    ", quantidadeDados=" + quantidadeDados +
                    ", operadora=" + operadora +
                    ", nome='" + nome + '\'' +
                    ", valor=" + valor + " }\n";
        }
        return "Plano{" +
                "idPlano=" + idPlano +
                ", quantidadeDados=" + quantidadeDados +
                ", quantidadeDadosBonus=" + quantidadeDadosBonus +
                ", operadora=" + operadora +
                ", nome='" + nome + '\'' +
                ", beneficio='" + beneficio + '\'' +
                ", valor=" + valor + " }\n";
    }
}
