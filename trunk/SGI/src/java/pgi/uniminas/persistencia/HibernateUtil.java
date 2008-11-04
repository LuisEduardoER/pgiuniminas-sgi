package pgi.uniminas.persistencia;


import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

/**
 * HibernateUtil.java classe com um método prático para obter Objeto 
 * Session Factory.
 * @author g1
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            // Crie o padrão de SessionFactory (hibernate.cfg.xml) 
            // Arquivo de Configuração
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
