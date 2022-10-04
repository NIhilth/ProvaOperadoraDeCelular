package model.entities;

/**
 * Exceção para quando uma DAO não conseguir estabelecer uma conexão
 * com o banco de dados
 */
public class ErroConexaoException extends Exception{

    public ErroConexaoException(){super("Erro ao tentar iniciar uma conexão com o banco!");}
}
