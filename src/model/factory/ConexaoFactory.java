package model.factory;

import model.entities.ErroConexaoException;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Factory da conexão com o banco de dados utilizando a url do banco
 * o username e a senha
 */
public class ConexaoFactory {
    private final String URL = "jdbc:mysql://localhost:3306/aplicacaooperadora";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";

    public Connection conectaBD() throws ErroConexaoException {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception excecao) {
            throw new ErroConexaoException();
        }
    }
}
