
package pgi.uniminas.persistencia;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;
import pgi.uniminas.entidades.ImovelOut;

/**
 *
 * @author G1
 */
public class ImovelOutHibDao implements ImovelOutDao{

    private List<ImovelOut> imovelOutList;
    private ImovelOut imovelOut;
    private Session session;

    public List<ImovelOut> getImoveisOut() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            imovelOutList = session.createQuery("from ImovelOut as i " +
                    "inner join fetch i.endereco").list();
            return imovelOutList;
        } catch (RuntimeException e) {
            System.out.print("Erro de SQL: " + e);
            return null;
        } finally {
            session.close();
        }
    }

    public ImovelOut getImovelOut(int codImovel) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from ImovelOut as i " +
                    "inner join fetch i.endereco " +
                    "where i.codImovel = :codimovel");
            q.setInteger("codimovel", codImovel);
            imovelOut = (ImovelOut) q.uniqueResult();
            return imovelOut;
        } catch (RuntimeException e) {
            System.out.print("Erro de SQL: " + e);
            return null;
        } finally {
            session.close();
        }
    }

    public void insertImovel(ImovelOut imvO) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.save(imvO);
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

    public void updateImovel(ImovelOut imvO) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.update(imvO);
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

    public void deleteImovel(ImovelOut[] imvO) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            for (int i = 0; i < imvO.length; i++) {
                imovelOut = (ImovelOut) session.get(ImovelOut.class, imvO[i].getCodImovel());
                session.delete(imovelOut);
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
