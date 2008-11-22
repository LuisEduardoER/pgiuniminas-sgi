package pgi.uniminas.negocio;

import java.util.List;
import pgi.uniminas.persistencia.ImovelDao;
import pgi.uniminas.persistencia.ImovelHibDao;
import pgi.uniminas.entidades.Imovel;

/**
 *
 * @author G1
 */
public class ImovelNeg implements ImovelDao {

    private ImovelDao dao = new ImovelHibDao();

    public ImovelNeg() {
        this.dao = new ImovelHibDao();
    }

    public List<Imovel> getImoveis() {
        return dao.getImoveis();
    }

    public Imovel getImovel(int codImovel) {
        return dao.getImovel(codImovel);
    }

    public void insertImovel(Imovel i) {
        dao.insertImovel(i);
    }

    public void updateImovel(Imovel i) {
        dao.updateImovel(i);
    }

    public void deleteImovel(Imovel[] i) {
        dao.deleteImovel(i);
    }
}
