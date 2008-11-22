
package pgi.uniminas.negocio;

import java.util.List;
import pgi.uniminas.entidades.Contexto;
import pgi.uniminas.persistencia.ContextoDao;
import pgi.uniminas.persistencia.ContextoHibDao;

/**
 *
 * @author G1
 */
public class ContextoNeg implements ContextoDao{

    private ContextoDao dao = new ContextoHibDao();

    public ContextoNeg() {
        this.dao = new ContextoHibDao();
    }

    public Contexto getContexto(int codContexto){
        return dao.getContexto(codContexto);
    }

    public List<Contexto> getContextos(){
        return dao.getContextos();
    }

    public void insertContexto(Contexto con) {
        dao.insertContexto(con);
    }

    public void updateContexto(Contexto con) {
        dao.updateContexto(con);
    }

    public void deleteContexto(Contexto[] con){
        dao.deleteContexto(con);
    }

}
