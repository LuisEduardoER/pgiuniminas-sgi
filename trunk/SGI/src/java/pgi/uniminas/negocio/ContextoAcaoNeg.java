
package pgi.uniminas.negocio;

import java.util.List;
import pgi.uniminas.entidades.ContextoAcao;
import pgi.uniminas.persistencia.ContextoAcaoDao;
import pgi.uniminas.persistencia.ContextoAcaoHibDao;

/**
 *
 * @author G1
 */
public class ContextoAcaoNeg implements ContextoAcaoDao {

    private ContextoAcaoDao dao = new ContextoAcaoHibDao();

    public ContextoAcaoNeg(){
        this.dao = new ContextoAcaoHibDao();
    }

    public List<ContextoAcao> getContextoAcoes() {
        return dao.getContextoAcoes();
    }

    public ContextoAcao getContextoAcao(int codContextoAcao) {
        return getContextoAcao(codContextoAcao);
    }

    public void insertContextoAcao(ContextoAcao cA) {
        dao.insertContextoAcao(cA);
    }

    public void updateContextoAcao(ContextoAcao cA) {
        dao.updateContextoAcao(cA);
    }

    public void deleteContextoAcao(ContextoAcao[] cA) {
        dao.deleteContextoAcao(cA);
    }

}
