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

    public List getImoveis() {
        return dao.getImoveis();
    }
}
