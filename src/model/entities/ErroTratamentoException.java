package model.entities;

/**
 * Exceção para quando a conversão dos dados pegos do banco para os formatos
 * JAVA não conseguir ser feita
 */
public class ErroTratamentoException extends Exception{

    public ErroTratamentoException(){super("Ocorreu um erro ao tratar a execução");}
}
