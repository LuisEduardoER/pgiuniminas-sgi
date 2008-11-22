
package pgi.uniminas.negocio;

import java.util.List;
import pgi.uniminas.entidades.ImovelCom;
import pgi.uniminas.persistencia.ImovelComDao;
import pgi.uniminas.persistencia.ImovelComHibDao;

/**
 *
 * @author G1
 */
public class ImovelComNeg implements ImovelComDao{

    private ImovelComDao dao = new ImovelComHibDao();

    public ImovelComNeg(){
        this.dao = new ImovelComHibDao();
    }

    public List<ImovelCom> getImoveisCom() {
        return dao.getImoveisCom();
    }

    public ImovelCom getImovelCom(int codImovel) {
        return dao.getImovelCom(codImovel);
    }

    public void insertImovel(ImovelCom imvC) {
        dao.insertImovel(imvC);
    }

    public void updateImovel(ImovelCom imvC) {
        dao.updateImovel(imvC);
    }

    public void deleteImovel(ImovelCom[] imvC) {
        dao.deleteImovel(imvC);
    }

}
