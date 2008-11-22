package pgi.uniminas.persistencia;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pgi.uniminas.entidades.ImovelCom;

/**
 *
 * @author G1
 */
public class ImovelComHibDao implements ImovelComDao {

    private List<ImovelCom> imovelComList;
    private ImovelCom imovelCom;
    private Session session;

    public List<ImovelCom> getImoveisCom() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            imovelComList = session.createQuery("from ImovelCom as i " +
                    "inner join fetch i.endereco").list();
            return imovelComList;
        } catch (RuntimeException e) {
            System.out.print("Erro de SQL: " + e);
            return null;
        } finally {
            session.close();
        }
    }

    public ImovelCom getImovelCom(int codImovel) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from ImovelCom as i " +
                    "inner join fetch i.endereco " +
                    "where i.codImovel = :codimovel");
            q.setInteger("codimovel", codImovel);
            imovelCom = (ImovelCom) q.uniqueResult();
            return imovelCom;
        } catch (RuntimeException e) {
            System.out.print("Erro de SQL: " + e);
            return null;
        } finally {
            session.close();
        }
    }

    public void insertImovel(ImovelCom imvC) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.save(imvC);
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

    public void updateImovel(ImovelCom imvC) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.update(imvC);
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

    public void deleteImovel(ImovelCom[] imvC) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            for (int i = 0; i < imvC.length; i++) {
                imovelCom = (ImovelCom) session.get(ImovelCom.class, imvC[i].getCodImovel());
                session.delete(imovelCom);
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
