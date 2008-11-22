package pgi.uniminas.persistencia;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pgi.uniminas.entidades.Funcionario;

/**
 *
 * @author G1
 */
public class FuncionarioHibDao implements FuncionarioDao {

    private List<Funcionario> funcionarioList;
    private Funcionario funcionario;
    private Session session;

    public List<Funcionario> getFuncionarios() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            funcionarioList = session.createQuery("from Funcionario as f" +
                    "inner join fetch f.codpessoa p").list();
            return funcionarioList;
        } catch (RuntimeException e) {
            System.out.print("Erro de SQL: " + e);
            return null;
        } finally {
            session.close();
        }
    }

    public Funcionario getFuncionario(int codFuncionario) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Funcionario as f" +
                    "inner join fetch f.codpessoa p" +
                    "where p.codpessoa = :codfuncionario");
            q.setInteger("codfuncionario", codFuncionario);
            funcionario = (Funcionario) q.uniqueResult();
            return funcionario;
        } catch (RuntimeException e) {
            System.out.print("Erro de SQL: " + e);
            return null;
        } finally {
            session.close();
        }
    }

    public void insertFuncionario(Funcionario fun) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = session.beginTransaction();
        try {
            tr = session.beginTransaction();
            session.save(fun);
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

    public void updateFuncionario(Funcionario fun) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = session.beginTransaction();
        try {
            tr = session.beginTransaction();
            session.update(fun);
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

    public void deleteFuncionario(Funcionario[] fun) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            for (int i = 0; i <= fun.length; i++) {
                funcionario = (Funcionario) session.get(Funcionario.class, fun[i].getCodPessoa());
                session.delete(funcionario);
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
