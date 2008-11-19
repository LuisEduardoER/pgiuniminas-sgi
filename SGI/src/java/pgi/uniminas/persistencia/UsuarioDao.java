package pgi.uniminas.persistencia;

import java.util.List;
import pgi.uniminas.entidades.Usuario;

/**
 *
 * @author G1
 */
public interface UsuarioDao {

    public List getUsuarios();

    public Usuario getUsuario(int codUsuario);

    public void insertUsuario(Usuario us);

    public void updateUsuario(Usuario us);

    public void deleteUsuario(Usuario[] us);
}
