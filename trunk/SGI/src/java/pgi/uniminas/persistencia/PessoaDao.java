package pgi.uniminas.persistencia;

import java.util.List;
import pgi.uniminas.entidades.Pessoa;

/**
 *
 * @author G1
 */
public interface PessoaDao {
    public Pessoa getPessoa(int codPessoa);
    public List getPessoas();
    public void insertPessoa(Pessoa p);
    public void updatePessoa(Pessoa p);
    public void deletePessoa(int codPessoa);
}