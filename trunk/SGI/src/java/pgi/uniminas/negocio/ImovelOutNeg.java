
package pgi.uniminas.negocio;

import java.util.List;
import pgi.uniminas.entidades.ImovelOut;
import pgi.uniminas.persistencia.ImovelOutDao;
import pgi.uniminas.persistencia.ImovelOutHibDao;

/**
 *
 * @author G1
 */
public class ImovelOutNeg implements ImovelOutDao {

    private ImovelOutDao dao = new ImovelOutHibDao();

    public ImovelOutNeg(){
        this.dao = new ImovelOutHibDao();
    }

    public List<ImovelOut> getImoveisOut() {
        return dao.getImoveisOut();
    }

    public ImovelOut getImovelOut(int codImovel) {
        return dao.getImovelOut(codImovel);
    }

    public void insertImovel(ImovelOut imvO) {
        dao.insertImovel(imvO);
    }

    public void updateImovel(ImovelOut imvO) {
        dao.updateImovel(imvO);
    }

    public void deleteImovel(ImovelOut[] imvO) {
        dao.deleteImovel(imvO);
    }
}
