package pgi.uniminas.persistencia;

import java.util.List;
import pgi.uniminas.entidades.ImovelRes;

/**
 *
 * @author G1
 */
public interface ImovelResDao {

    public List<ImovelRes> getImoveisRes();

    public ImovelRes getImovelRes(int codImovel);

    public void insertImovelRes(ImovelRes imvR);

    public void updateImovelRes(ImovelRes imvR);

    public void deleteImovelRes(ImovelRes[] imvR);
}
