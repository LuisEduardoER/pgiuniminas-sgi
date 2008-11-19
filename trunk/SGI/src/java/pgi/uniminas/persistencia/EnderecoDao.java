package pgi.uniminas.persistencia;

import java.util.List;
import pgi.uniminas.entidades.Endereco;

/**
 *
 * @author G1
 */
public interface EnderecoDao {

    public List getEnderecos();

    public Endereco getEndereco(String codCep);

    public void insertEndereco(Endereco end);

    public void updateEndereco(Endereco end);

    public void deleteEndereco(Endereco [] end);
}
