package pgi.uniminas.persistencia;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pgi.uniminas.entidades.Endereco;

/**
 *
 * @author G1
 */
public class EnderecoHibDao implements EnderecoDao {

    private List<Endereco> enderecoList;
    private Endereco endereco;
    private Session session;

    public List getEnderecos() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            enderecoList = session.createQuery("from endereco as e").list();
            return enderecoList;
        } catch (RuntimeException e) {
            System.out.print("Erro de SQL: " + e);
            return null;
        } finally {
            session.clear();
        }
    }

    public Endereco getEndereco(String codCep) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from endereco as e" +
                    "where e.codcep = :codcep");
            q.setString("codcep", codCep);
            return (Endereco) q.uniqueResult();
        } catch (RuntimeException e) {
            System.out.print("Erro de SQL: " + e);
            return null;
        } finally {
            session.close();
        }
    }

    public void insertEndereco(Endereco end) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.save(end);
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

    public void updateEndereco(Endereco end) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.update(end);
            tr.commit();
        } catch (RuntimeException e) {
            if(tr != null){
                tr.rollback();
            }throw e;
        } finally {
            session.close();
        }
    }

    public void deleteEndereco(Endereco[] end) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            for (int i = 0; i < end.length; i++) {
                Endereco e = (Endereco) session.get(Endereco.class, end[i].getCodCep());
                session.delete(e);
            }
            tr.commit();
        } catch (RuntimeException e) {
            if(tr != null){
                tr.rollback();
            }throw e;
        } finally {
            session.close();
        }
    }
}
