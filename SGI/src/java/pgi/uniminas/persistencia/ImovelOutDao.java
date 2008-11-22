package pgi.uniminas.persistencia;

import java.util.List;
import pgi.uniminas.entidades.ImovelOut;

/**
 *
 * @author G1
 */
public interface ImovelOutDao {

    public List<ImovelOut> getImoveisOut();

    public ImovelOut getImovelOut(int codImovel);

    public void insertImovel(ImovelOut imvO);

    public void updateImovel(ImovelOut imvO);

    public void deleteImovel(ImovelOut[] imvO);
}
