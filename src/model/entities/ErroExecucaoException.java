package model.entities;

/**
 * Exceção para quando a execução de um mysql statement der errado
 */
public class ErroExecucaoException extends Exception{

    public ErroExecucaoException(){super("Houve um erro ao tentar executar a ação");}
}
