package pgi.uniminas.negocio;

import java.util.List;
import pgi.uniminas.entidades.PercentComissao;
import pgi.uniminas.persistencia.PercentComissaoDao;
import pgi.uniminas.persistencia.PercentComissaoHibDao;

/**
 *
 * @author G1
 */
public class PercentComissaoNeg implements PercentComissaoDao {

    private PercentComissaoDao dao = new PercentComissaoHibDao();

    public PercentComissaoNeg() {
        this.dao = new PercentComissaoHibDao();
    }

    public List<PercentComissao> getPercentComissoes(){
        return dao.getPercentComissoes();
    }

    public PercentComissao getPercentComissao(int codCorretor) {
        return dao.getPercentComissao(codCorretor);
    }

    public void insertPercentComissao(PercentComissao p) {
        dao.insertPercentComissao(p);
    }

    public void updatePercentComissao(PercentComissao p) {
        dao.updatePercentComissao(p);
    }

    public void deletePercentComissao(PercentComissao p) {
        dao.deletePercentComissao(p);
    }
}
