
package pgi.uniminas.persistencia;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pgi.uniminas.entidades.ImovelRes;

/**
 *
 * @author G1
 */
public class ImovelResHibDao implements ImovelResDao{

    private List<ImovelRes> imovelResList;
    private ImovelRes imovelRes;
    private Session session;

    public List<ImovelRes> getImoveisRes() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            imovelResList = session.createQuery("from ImovelRes as i " +
                    "inner join fetch i.endereco").list();
            return imovelResList;
        } catch (RuntimeException e) {
            System.out.print("Erro de SQL: " + e);
            return null;
        } finally {
            session.close();
        }
    }

    public ImovelRes getImovelRes(int codImovel) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from ImovelRes as i " +
                    "inner join fetch i.endereco " +
                    "where i.codImovel = :codimovel");
            q.setInteger("codimovel", codImovel);
            imovelRes = (ImovelRes) q.uniqueResult();
            return imovelRes;
        } catch (RuntimeException e) {
            System.out.print("Erro de SQL: " + e);
            return null;
        } finally {
            session.close();
        }
    }

    public void insertImovelRes(ImovelRes imvR) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.save(imvR);
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

    public void updateImovelRes(ImovelRes imvR) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.update(imvR);
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

    public void deleteImovelRes(ImovelRes[] imvR) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            for (int i = 0; i < imvR.length; i++) {
                imovelRes = (ImovelRes) session.get(ImovelRes.class, imvR[i].getCodImovel());
                session.delete(imovelRes);
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
