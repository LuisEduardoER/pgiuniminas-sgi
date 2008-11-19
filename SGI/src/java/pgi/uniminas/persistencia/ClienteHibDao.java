package pgi.uniminas.persistencia;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pgi.uniminas.entidades.Cliente;

/**
 *
 * @author G1
 */
public class ClienteHibDao implements ClienteDao {

    private List clienteList;
    private Cliente cliente;
    private Session session;

    public List getClientes() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            clienteList = session.createQuery("from cliente as c" +
                    "inner fetch join c.codpessoa" +
                    "inner fetch join c.codcep").list();
            return clienteList;
        } catch (RuntimeException e) {
            System.out.print("Erro de SQL: " + e);
            return null;
        } finally {
            session.close();
        }
    }

    public Cliente getCliente(int codCliente) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from cliente as c" +
                    "inner fetch join c.codpessoa" +
                    "inner fetch join c.codcep" +
                    "where c.codcliente = :codcliente");
            q.setInteger("codcliente", codCliente);
            return (Cliente) q.uniqueResult();
        } catch (RuntimeException e) {
            System.out.print("Erro de SQL: " + e);
            return null;
        } finally {
            session.close();
        }
    }

    public void insertCliente(Cliente cli) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.save(cli);
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

    public void updateCliente(Cliente cli) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.save(cli);
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

    public void deleteCliente(Cliente[] cli) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            for (int i = 0; i < cli.length; i++) {
                cliente = (Cliente) session.get(Cliente.class, cli[i].getCodPessoa());
                session.delete(cliente);
            }
            tr.commit();
        } catch (RuntimeException e) {
            if (tr != null) {
                tr.rollback();
            }
        }
    }
}
