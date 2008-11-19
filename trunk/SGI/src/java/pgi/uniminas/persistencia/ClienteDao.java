package pgi.uniminas.persistencia;

import java.util.List;
import pgi.uniminas.entidades.Cliente;

/**
 *
 * @author G1
 */
public interface ClienteDao {

    public List getClientes();

    public Cliente getCliente(int codCliente);

    public void insertCliente(Cliente cli);

    public void updateCliente(Cliente cli);

    public void deleteCliente(Cliente[] cli);
}
