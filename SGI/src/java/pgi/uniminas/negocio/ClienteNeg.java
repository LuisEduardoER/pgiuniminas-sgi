package pgi.uniminas.negocio;

import java.util.List;
import pgi.uniminas.entidades.Cliente;
import pgi.uniminas.persistencia.ClienteDao;
import pgi.uniminas.persistencia.ClienteHibDao;

/**
 *
 * @author G1
 */
public class ClienteNeg implements ClienteDao {

    private ClienteDao dao = new ClienteHibDao();

    public ClienteNeg() {
        this.dao = new ClienteHibDao();
    }

    public Cliente getCliente(int codCliente) {
        return dao.getCliente(codCliente);
    }

    public List<Cliente> getClientes() {
        return dao.getClientes();
    }

    public void insertCliente(Cliente c) {
        dao.insertCliente(c);
    }

    public void updateCliente(Cliente c) {
        dao.updateCliente(c);
    }

    public void deleteCliente(Cliente[] c) {
        dao.deleteCliente(c);
    }
}
