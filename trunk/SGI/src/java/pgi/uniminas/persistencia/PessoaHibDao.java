package pgi.uniminas.persistencia;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pgi.uniminas.entidades.Pessoa;

/**
 *
 * @author G1
 */
public class PessoaHibDao implements PessoaDao {

    private List<Pessoa> pessoaList;
    private Pessoa pess;
    private Session session;

    @Override
    public Pessoa getPessoa(int codPessoa) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Pessoa as p " +
                    "left join fetch p.endereco " +
                    "where p.codpessoa = :codPessoa");
            q.setInteger("codpessoa", codPessoa);
            return (Pessoa) q.uniqueResult();
        } catch (Exception e) {
            System.out.print("Erro de SQL: " + e);
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List getPessoas() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            pessoaList = session.createQuery("from Pessoa as p " +
                    "left join fetch p.endereco").list();
            return pessoaList;
        } catch (Exception e) {
            System.out.println("Erro de SQL: " + e);
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void insertPessoa(Pessoa p) {
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

    @Override
    public void updatePessoa(Pessoa p) {
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

    @Override
    public void deletePessoa(Pessoa[] p) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            for (int i = 0; i < p.length; i++) {
                pess = (Pessoa) session.get(Pessoa.class, p[i].getCodPessoa());
                session.delete(pess);
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

   /* public static void main(String[] a){
        PessoaHibDao c = new PessoaHibDao();
        List lista = c.getPessoas();
        for (Iterator it = lista.iterator(); it.hasNext();) {
            Pessoa o = (Pessoa)it.next();
            System.out.println(o.getNomPessoa());
        }
    }*/
}
