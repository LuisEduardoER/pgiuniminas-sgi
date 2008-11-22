package pgi.uniminas.persistencia;

import java.util.List;
import pgi.uniminas.entidades.ImovelCom;

/**
 *
 * @author G1
 */
public interface ImovelComDao {

    public List<ImovelCom> getImoveisCom();

    public ImovelCom getImovelCom(int codImovel);

    public void insertImovel(ImovelCom imvC);

    public void updateImovel(ImovelCom imvC);

    public void deleteImovel(ImovelCom[] imvC);
}
