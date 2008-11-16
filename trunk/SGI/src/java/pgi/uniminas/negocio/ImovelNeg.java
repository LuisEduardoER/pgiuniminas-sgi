package pgi.uniminas.negocio;

import java.util.List;
import pgi.uniminas.persistencia.ImovelDao;
import pgi.uniminas.persistencia.ImovelHibDao;
import pgi.uniminas.entidades.Imovel;

/**
 *
 * @author G1
 */
public class ImovelNeg {

    private ImovelDao dao = new ImovelHibDao();

    public ImovelNeg() {
        this.dao = new ImovelHibDao();
    }

    public void insertImovel(Imovel i){
        dao.insertImovel(i);
    }

    public List getImoveis() {
        return dao.getImoveis();
    }
    
    public Imovel getImovel(int codImovel){
        return dao.getImovel(codImovel);
    }

    public void deleteImovel(Imovel [] i){
        dao.deleteImovel(i);
    }
}
