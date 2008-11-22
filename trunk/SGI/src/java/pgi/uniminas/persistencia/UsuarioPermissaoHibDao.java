
package pgi.uniminas.persistencia;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pgi.uniminas.entidades.ContextoAcao;
import pgi.uniminas.entidades.Usuario;
import pgi.uniminas.entidades.UsuarioPermissao;

/**
 *
 * @author G1
 */
public class UsuarioPermissaoHibDao implements UsuarioPermissaoDao{

    private List<UsuarioPermissao> usuarioPermissaoList;
    private UsuarioPermissao usuarioPermissao;
    private Session session;

    public List<UsuarioPermissao> getUsuarioPermissao(Usuario u, ContextoAcao p) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from UsuarioPermissao as p" +
                    "inner join fetch p.codusuario u" +
                    "inner join fetch p.codacao a" +
                    "where p.codusuario = :u" +
                    "and p.codacao = :p");
            int codusuario = u.getCodUsuario();
            int codacao = p.getCodAcao();
            q.setInteger(codusuario, codacao);
            usuarioPermissaoList = q.list();
            return usuarioPermissaoList;

        }catch(RuntimeException e){
            System.out.print("Erro de SQL: " + e);
            return null;
        }finally {
            session.close();
        }
    }

    public void insertUsuarioPermissao(UsuarioPermissao uP) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.save(uP);
            tr.commit();
        } catch (RuntimeException e) {
            if (tr != null) {
                tr.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public void updateUsuarioPermissao(UsuarioPermissao uP) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.update(uP);
            tr.commit();
        } catch (RuntimeException e) {
            if (tr != null) {
                tr.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public void deleteUsuarioPermissao(UsuarioPermissao uP) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
