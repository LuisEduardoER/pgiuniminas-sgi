package pgi.uniminas.persistencia;

import java.util.List;
import pgi.uniminas.entidades.ContextoAcao;
import pgi.uniminas.entidades.Usuario;
import pgi.uniminas.entidades.UsuarioPermissao;

/**
 *
 * @author G1
 */
public interface UsuarioPermissaoDao {

    public List<UsuarioPermissao> getUsuarioPermissao(Usuario u, ContextoAcao p);

    public void insertUsuarioPermissao(UsuarioPermissao uP);

    public void updateUsuarioPermissao(UsuarioPermissao uP);

    public void deleteUsuarioPermissao(UsuarioPermissao uP);
}
