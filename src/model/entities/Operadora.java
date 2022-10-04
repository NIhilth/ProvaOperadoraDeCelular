package model.entities;

/**
 * Enum das operadoras possíveis para um plano
 */
public enum Operadora {
    VIVO("VIVO"),
    CLARO("CLARO"),
    TIM("TIM"),
    OI("OI");

    private String nome;

    Operadora(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
