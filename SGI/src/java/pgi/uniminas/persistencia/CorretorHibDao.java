
package pgi.uniminas.persistencia;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pgi.uniminas.entidades.Corretor;

/**
 *
 * @author G1
 */
public class CorretorHibDao implements CorretorDao {
    public List<Corretor> corretorList;
    public Corretor corretor;
    public Session session;

    public List<Corretor> getCorretores() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            corretorList = session.createQuery("from Corretor as c" +
                    "inner join fetch c.codpessoa p" +
                    "left join fetch c.codcep e").list();
            return corretorList;
        }catch (RuntimeException e) {
            System.out.print("Erro de SQL: " + e);
            return null;
        }finally {
            session.close();
        }
    }

    public Corretor getCorretor(int codCorretor) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Corretor as c" +
                    "inner join fetch c.codpessoa p" +
                    "left join fetch c.codcep e" +
                    "where c.codpessoa = :codcorretor");
            q.setInteger("codcorretor", codCorretor);
            corretor = (Corretor) q.uniqueResult();
            return corretor;
        }catch(RuntimeException e){
            System.out.print("Erro de SQL: " + e);
            return null;
        }finally {
            session.close();
        }
    }

    public void insertCorretor(Corretor cor) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.save(cor);
            tr.commit();
        }catch(RuntimeException e){
            if(tr != null){
                tr.rollback();
            }throw e;
        } finally {
            session.close();
        }
    }

    public void updateCorretor(Corretor cor) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.update(cor);
            tr.commit();
        }catch (RuntimeException e) {
            if(tr != null){
                tr.rollback();
            }throw e;
        }finally {
            session.close();
        }
    }

    public void deleteCorrtor(Corretor[] cor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}
