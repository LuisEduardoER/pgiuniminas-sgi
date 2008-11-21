package pgi.uniminas.persistencia;

import java.util.List;
import pgi.uniminas.entidades.Contexto;

/**
 *
 * @author G1
 */
public interface ContextoDao {

    public List<Contexto> getContextos();

    public Contexto getContexto(int codContexto);

    public void insertContexto(Contexto con);

    public void updateContexto(Contexto con);

    public void deleteContexto(Contexto[] con);
}
