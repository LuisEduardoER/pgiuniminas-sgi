package pgi.uniminas.persistencia;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pgi.uniminas.entidades.PercentComissao;

/**
 *
 * @author G1
 */
public class PercentComissaoHibDao implements PercentComissaoDao {

    private PercentComissao percentComissao;
    private Session session;

    public PercentComissao getPercentComissao(int codCorretor) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from PercentComissao as c" +
                    "inner join fetch c.codpessoa p" +
                    "where p.codpessoa = :codcorretor");
            q.setInteger("codcorretor", codCorretor);
            percentComissao = (PercentComissao) q.uniqueResult();
            return percentComissao;
        } catch (RuntimeException e) {
            System.out.print("Erro de SQL: " + e);
            return null;
        } finally {
            session.close();
        }
    }

    public void insertPercentComissao(PercentComissao p) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.save(p);
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

    public void updatePercentComissao(PercentComissao p) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.update(p);
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

    public void deletePercentComissao(PercentComissao p) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            percentComissao = (PercentComissao) session.get(PercentComissao.class, p.getCorretor().getCodPessoa());
            session.delete(percentComissao);
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
