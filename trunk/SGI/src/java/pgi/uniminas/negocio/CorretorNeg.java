
package pgi.uniminas.negocio;

import java.util.List;
import pgi.uniminas.entidades.Corretor;
import pgi.uniminas.persistencia.CorretorDao;
import pgi.uniminas.persistencia.CorretorHibDao;

/**
 *
 * @author G1
 */
public class CorretorNeg implements CorretorDao {

    private CorretorDao dao = new CorretorHibDao();

    public CorretorNeg() {
        this.dao = new CorretorHibDao();
    }

    public Corretor getCorretor(int codCorretor){
        return dao.getCorretor(codCorretor);
    }

    public List<Corretor> getCorretores() {
        return dao.getCorretores();
    }

    public void insertCorretor(Corretor cor) {
        dao.insertCorretor(cor);
    }

    public void updateCorretor(Corretor cor) {
        dao.updateCorretor(cor);
    }

    public void deleteCorretor(Corretor[] cor) {
        dao.deleteCorretor(cor);
    }

}
