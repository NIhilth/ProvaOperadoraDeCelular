package model.service;

import model.dao.PlanoDAO;
import model.entities.Operadora;
import model.entities.Plano;

import java.util.ArrayList;

/**
 * Classe de ponte entre o PlanoDAO e o PlanoController, torna as possíveis exceções do dao
 * em RuntimeExceptions e passando o erro gerado
 */
public class PlanoService {
    private PlanoDAO planoDAO;

    public PlanoService(){
        try {
            this.planoDAO = new PlanoDAO();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void cadastrar(Plano plano) {
        try {
            planoDAO.insert(plano);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public ArrayList<Plano> listarTodos(){
        try {
            return planoDAO.selectAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public ArrayList<Plano> listarPorOperadora(Operadora operadora){
        try {
            return planoDAO.selectbyOperadora(operadora);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Plano selecionarPlano(int idPlano){
        try {
            return planoDAO.selectById(idPlano);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deletar(int idPlano){
        try {
            planoDAO.delete(idPlano);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void editar(int idPlano, Plano novoPlano){
        try {
            planoDAO.update(idPlano, novoPlano);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
