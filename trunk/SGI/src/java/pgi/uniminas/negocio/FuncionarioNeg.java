package pgi.uniminas.negocio;

import java.util.List;
import pgi.uniminas.entidades.Funcionario;
import pgi.uniminas.persistencia.FuncionarioDao;
import pgi.uniminas.persistencia.FuncionarioHibDao;

/**
 *
 * @author G1
 */
public class FuncionarioNeg implements FuncionarioDao {

    private FuncionarioDao dao = new FuncionarioHibDao();

    public FuncionarioNeg() {
        this.dao = new FuncionarioHibDao();
    }

    public List<Funcionario> getFuncionarios() {
        return dao.getFuncionarios();
    }

    public Funcionario getFuncionario(int codFuncionario) {
        return dao.getFuncionario(codFuncionario);
    }

    public void insertFuncionario(Funcionario fun) {
        dao.insertFuncionario(fun);
    }

    public void updateFuncionario(Funcionario fun) {
        dao.updateFuncionario(fun);
    }

    public void deleteFuncionario(Funcionario[] fun) {
        dao.deleteFuncionario(fun);
    }
}
