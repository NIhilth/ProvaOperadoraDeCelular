package model.dao;

import model.entities.*;
import model.factory.ConexaoFactory;
import model.factory.PlanoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe de ponte entre o PlanoService e o banco de dados, tendo como único atributo
 * a conexão com esse banco, para poder fazer as ações necessárias
 */
public class PlanoDAO {
    private Connection connection;

    public PlanoDAO() throws ErroConexaoException {
        this.connection = new ConexaoFactory().conectaBD();
    }

    public void insert(Plano novoPlano)
            throws SQLException, ErroExecucaoException {
        String sql = "insert into plano (idPLANO , operadora , nome , quantidade_de_dados , " +
                "beneficios , valor, quantidade_de_dados_bonus) values (?,?,?,?,?,?,?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, 0);
            statement.setString(2, novoPlano.getOperadora().getNome());
            statement.setString(3, novoPlano.getNome());
            statement.setInt(4, novoPlano.getQuantidadeDados());
            statement.setString(5, novoPlano.getBeneficio());
            statement.setDouble(6, novoPlano.getValor());
            statement.setInt(7, novoPlano.getQuantidadeDadosBonus());
            try {
                statement.execute();
            } catch (Exception exception) {
                throw new ErroExecucaoException();
            }
        } catch (Exception exception) {
            throw exception;
        }
    }

    public Plano selectById(Integer idPlano)
            throws SQLException, ErroExecucaoException, ErroTratamentoException {
        String sql = "select * from plano where idPLANO = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idPlano);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new PlanoFactory().getPlano(resultSet, true);
                }
            } catch (Exception exception) {
                if(exception instanceof ErroTratamentoException){
                    throw exception;
                }
                throw new ErroExecucaoException();
            }
        } catch (Exception exception) {
            throw exception;
        }
        return null;
    }

    public ArrayList<Plano> selectbyOperadora(Operadora operadora)
            throws SQLException, ErroExecucaoException, ErroTratamentoException {
        String sql = "select plano.idPLANO , plano.operadora, plano.nome, " +
                "plano.quantidade_de_dados, plano.valor from plano where plano.operadora = ?";
        ArrayList<Plano> listaPlanos = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, operadora.getNome());
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Plano planoOperadora = new PlanoFactory().getPlano(resultSet, false);
                    listaPlanos.add(planoOperadora);
                }
            } catch (Exception exception) {
                if(exception instanceof ErroTratamentoException){
                    throw exception;
                }
                throw new ErroExecucaoException();
            }
        } catch (Exception exception) {
            throw exception;
        }
        return listaPlanos;
    }

    public ArrayList<Plano> selectAll()
            throws SQLException, ErroExecucaoException, ErroTratamentoException {
        String sql = "select plano.idPLANO , plano.operadora, plano.nome, " +
                "plano.quantidade_de_dados, plano.valor from plano order by plano.operadora";
        ArrayList<Plano> listaPlanos = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Plano planoOperadora = new PlanoFactory().getPlano(resultSet, false);
                    listaPlanos.add(planoOperadora);
                }
            } catch (Exception exception) {
                if(exception instanceof ErroTratamentoException){
                    throw exception;
                }
                throw new ErroExecucaoException();
            }
        } catch (Exception exception) {
            throw exception;
        }
        return listaPlanos;
    }

    public void delete(Integer idPlano)
            throws SQLException, ErroExecucaoException {
        String sql = "delete from plano where idPLANO = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idPlano);
            try {
                statement.execute();
            } catch (Exception exception) {
                throw new ErroExecucaoException();
            }
        } catch (Exception exception) {
            throw exception;
        }
    }

    public void update(Integer idPlano, Plano plano)
            throws SQLException, ErroExecucaoException {
        String sql = "update plano set operadora = ?, nome = ? , quantidade_de_dados = ? ,  " +
                "beneficios = ? , valor = ? , quantidade_de_dados_bonus = ?  where idPLANO = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, plano.getOperadora().getNome());
            statement.setString(2, plano.getNome());
            statement.setInt(3, plano.getQuantidadeDados());
            statement.setString(4, plano.getBeneficio());
            statement.setDouble(5, plano.getValor());
            statement.setInt(6, plano.getQuantidadeDadosBonus());
            statement.setInt(7, idPlano);
            try {
                statement.execute();
            } catch (Exception exception) {
                throw new ErroExecucaoException();
            }
        } catch (Exception exception) {
            throw exception;
        }
    }
}
