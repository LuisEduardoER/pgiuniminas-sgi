package pgi.uniminas.persistencia;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pgi.uniminas.entidades.Imovel;

/**
 *
 * @author G1
 */
public class ImovelHibDao implements ImovelDao{
    private List <Imovel> imovelList;
    private Imovel imovel;
    private Session session;


    public List getImoveis() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            session.beginTransaction();
            imovelList = session.createQuery("from imovel as p" +
                    "inner join fetch p.endereco").list();
            return imovelList;
        }catch(Exception e){
            System.out.print("Erro de SQL: " + e);
            return null;
        }finally{
            session.close();
        }
    }

    public Imovel getImovel(int codImovel) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void insertImovel(Imovel i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void updateImovel(Imovel i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void deleteImovel(Imovel[] im) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
