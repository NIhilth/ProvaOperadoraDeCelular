package model.factory;

import model.entities.ErroTratamentoException;
import model.entities.Operadora;
import model.entities.Plano;

import java.sql.ResultSet;

/**
 * Factory para criar um objeto completo ou não de um plano
 */
public class PlanoFactory {

    public Plano getPlano(ResultSet resultSet, boolean objetoCompleto)
            throws ErroTratamentoException {
        if(objetoCompleto){
            try {
                return new Plano(resultSet.getInt("idPLANO"),
                        resultSet.getInt("quantidade_de_dados"),
                        Operadora.valueOf(resultSet.getString("operadora")),
                        resultSet.getString("nome"),
                        resultSet.getString("beneficios"),
                        resultSet.getDouble("valor"),
                        resultSet.getInt("quantidade_de_dados_bonus"));
            } catch (Exception exception) {
                throw new ErroTratamentoException();
            }
        } else {
            try {
                return new Plano(resultSet.getInt("idPLANO"),
                        resultSet.getInt("quantidade_de_dados"),
                        Operadora.valueOf(resultSet.getString("operadora")),
                        resultSet.getString("nome"),
                        resultSet.getDouble("valor"));
            } catch (Exception exception) {
                throw new ErroTratamentoException();
            }
        }
    }
}
