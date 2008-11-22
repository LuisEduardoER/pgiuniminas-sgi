package pgi.uniminas.negocio;

import java.util.List;
import pgi.uniminas.entidades.Usuario;
import pgi.uniminas.persistencia.UsuarioDao;
import pgi.uniminas.persistencia.UsuarioHibDao;

/**
 *
 * @author G1
 */
public class UsuarioNeg implements UsuarioDao {

    private UsuarioDao dao = new UsuarioHibDao();

    public UsuarioNeg() {
        this.dao = new UsuarioHibDao();
    }

    public List getUsuarios() {
        return dao.getUsuarios();
    }

    public Usuario getUsuario(int codUsuario) {
        return dao.getUsuario(codUsuario);
    }

    public void insertUsuario(Usuario us) {
        dao.insertUsuario(us);
    }

    public void updateUsuario(Usuario us) {
        dao.updateUsuario(us);
    }

    public void deleteUsuario(Usuario[] us) {
        dao.deleteUsuario(us);

    }
}
