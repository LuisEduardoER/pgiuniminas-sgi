package pgi.uniminas.persistencia;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pgi.uniminas.entidades.ItemVisita;
import pgi.uniminas.entidades.Visita;

/**
 *
 * @author G1
 */
public class ItemVisitaHibDao implements ItemVisitaDao {

    private List<ItemVisita> itemVisitaList;
    private ItemVisita itemVisita;
    private Session session;

    public List<ItemVisita> getItensVisita(Visita v) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from ItemVisita as i" +
                    "inner join fetch i.codvisita v" +
                    "where v.codvisita = :codvisita");
            q.setInteger("codvisita", v.getcodVisita());
            itemVisitaList = q.list();
            return itemVisitaList;

        } catch (RuntimeException e) {
            System.out.print("Erro de SQL: " + e);
            return null;
        } finally {
            session.close();
        }
    }

    public void insertItemVisita(ItemVisita i) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.save(i);
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

    public void updateItemVisita(ItemVisita i) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.update(i);
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

    public void deleteItemVisita(ItemVisita[] iV) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            for (int i = 0; i <= iV.length; i++) {
                itemVisita = (ItemVisita) session.get(Visita.class, iV[i].getVisita().getcodVisita());
                session.delete(itemVisita);
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
