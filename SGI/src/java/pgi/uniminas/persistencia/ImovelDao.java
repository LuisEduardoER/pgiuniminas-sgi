package pgi.uniminas.persistencia;

import java.util.List;
import pgi.uniminas.entidades.*;

/**
 *
 * @author G1
 */
public interface ImovelDao {
    public List getImoveis();
    public Imovel getImovel(int codImovel);
    public void insertImovel(Imovel i);
    public void updateImovel(Imovel i);
    public void deleteImovel(Imovel [] im);

}
