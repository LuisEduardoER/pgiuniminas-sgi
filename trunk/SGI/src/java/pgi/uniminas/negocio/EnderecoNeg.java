
package pgi.uniminas.negocio;

import java.util.List;
import pgi.uniminas.entidades.Endereco;
import pgi.uniminas.persistencia.EnderecoDao;
import pgi.uniminas.persistencia.EnderecoHibDao;

/**
 *
 * @author G1
 */
public class EnderecoNeg implements EnderecoDao {

    private EnderecoDao dao = new EnderecoHibDao();

    public EnderecoNeg() {
        this.dao = new EnderecoHibDao();
    }

    public List<Endereco> getEnderecos() {
        return dao.getEnderecos();
    }

    public Endereco getEndereco(String codCep) {
        return dao.getEndereco(codCep);
    }

    public void insertEndereco(Endereco end) {
        dao.insertEndereco(end);
    }

    public void updateEndereco(Endereco end) {
        dao.updateEndereco(end);
    }

    public void deleteEndereco(Endereco[] end) {
        dao.deleteEndereco(end);
    }

}
