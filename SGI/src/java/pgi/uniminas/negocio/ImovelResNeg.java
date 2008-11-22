
package pgi.uniminas.negocio;

import java.util.List;
import pgi.uniminas.entidades.ImovelRes;
import pgi.uniminas.persistencia.ImovelResDao;
import pgi.uniminas.persistencia.ImovelResHibDao;

/**
 *
 * @author G1
 */
public class ImovelResNeg implements ImovelResDao{

    private ImovelResDao dao = new ImovelResHibDao();

    public ImovelResNeg(){
        this.dao = new ImovelResHibDao();
    }

    public List<ImovelRes> getImoveisRes(){
        return dao.getImoveisRes();
    }

    public ImovelRes getImovelRes(int codImovel) {
        return dao.getImovelRes(codImovel);
    }

    public void insertImovelRes(ImovelRes imvR) {
        dao.insertImovelRes(imvR);
    }

    public void updateImovelRes(ImovelRes imvR) {
        dao.updateImovelRes(imvR);
    }

    public void deleteImovelRes(ImovelRes[] imvR) {
        dao.deleteImovelRes(imvR);
    }

}
