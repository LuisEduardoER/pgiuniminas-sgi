package pgi.uniminas.persistencia;

import java.util.List;
import pgi.uniminas.entidades.Funcionario;

/**
 *
 * @author G1
 */
public interface FuncionarioDao {

    public List<Funcionario> getFuncionarios();

    public Funcionario getFuncionario(int codFuncionario);

    public void insertFuncionario(Funcionario fun);

    public void updateFuncionario(Funcionario fun);

    public void deleteFuncionario(Funcionario[] fun);
}
