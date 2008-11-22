
package pgi.uniminas.negocio;

import java.util.List;
import pgi.uniminas.entidades.Imovel;
import pgi.uniminas.entidades.Visita;
import pgi.uniminas.persistencia.VisitaDao;
import pgi.uniminas.persistencia.VisitaHibDao;

/**
 *
 * @author G1
 */
public class VisitaNeg implements VisitaDao {

    private VisitaDao dao = new VisitaHibDao();

    public VisitaNeg() {
        this.dao = new VisitaHibDao();
    }

    public List<Visita> getVisitas(Imovel im) {
        return dao.getVisitas(im);
    }

    public void insertVisita(Visita v) {
        dao.insertVisita(v);
    }

    public void updateVisita(Visita v) {
        dao.updateVisita(v);
    }

    public void deleteVisita(Visita[] v) {
        dao.deleteVisita(v);
    }

}
