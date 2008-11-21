package pgi.uniminas.persistencia;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pgi.uniminas.entidades.Contexto;

/**
 *
 * @author G1
 */
public class ContextoHibDao implements ContextoDao {

    private List<Contexto> contextoList;
    private Contexto contexto;
    private Session session;

    public List<Contexto> getContextos() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            contextoList = session.createQuery("from Contexto as c" +
                    "inner join fetch c.codusuario u").list();
            return contextoList;
        } catch (RuntimeException e) {
            System.out.print("Erro de SQL: " + e);
            return null;
        } finally {
            session.close();
        }

    }

    public Contexto getContexto(int codContexto) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Contexto as c" +
                    "inner join fetch c.codusuario u" +
                    "where c.codcontexto = :codcontexto");
            q.setInteger("codcontexto", codContexto);
            contexto = (Contexto) q.uniqueResult();
            return contexto;
        } catch (RuntimeException e) {
            System.out.print("Erro de SQL: " + e);
            return null;
        } finally {
            session.close();
        }
    }

    public void insertContexto(Contexto con) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.save(con);
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

    public void updateContexto(Contexto con) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.update(con);
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

    public void deleteContexto(Contexto[] con) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            for (int i = 0; i <= con.length; i++) {
                contexto = (Contexto) session.get(Contexto.class, con[i].getCodContexto());
                session.delete(contexto);
            }
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
}
