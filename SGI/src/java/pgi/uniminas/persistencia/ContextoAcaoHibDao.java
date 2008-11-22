
package pgi.uniminas.persistencia;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pgi.uniminas.entidades.ContextoAcao;

/**
 *
 * @author G1
 */
public class ContextoAcaoHibDao implements ContextoAcaoDao {

    private List<ContextoAcao> contextoAcaoList;
    private ContextoAcao contextoAcao;
    private Session session;

    public List<ContextoAcao> getContextoAcoes() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            contextoAcaoList = session.createQuery("from ContextoAcao c " +
                    "inner join  fetch c.contexto").list();
            return contextoAcaoList;
        } catch (RuntimeException e){
            System.out.print("Erro de SQL: " + e);
            return null;
        } finally {
            session.close();
        }
    }

    public ContextoAcao getContextoAcao(int codContextoAcao) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from ContextoAcao c " +
                    "inner join fetch c.contexto " +
                    "where c.codAcao = :codcontextoacao");
            q.setInteger("codcontextoacao", codContextoAcao);
            contextoAcao = (ContextoAcao) q.uniqueResult();
            return contextoAcao;
        } catch (RuntimeException e) {
            System.out.print("Erro de SQL: " + e);
            return null;
        } finally {
            session.close();
        }
    }

    public void insertContextoAcao(ContextoAcao cA) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.save(cA);
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

    public void updateContextoAcao(ContextoAcao cA) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.update(cA);
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

    public void deleteContextoAcao(ContextoAcao[] cA) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            for (int i = 0; i <= cA.length; i++) {
                contextoAcao = (ContextoAcao) session.get(ContextoAcao.class, cA[i].getCodAcao());
                session.delete(contextoAcao);
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
