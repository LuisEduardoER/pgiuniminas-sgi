package pgi.uniminas.persistencia;

import java.util.List;
import pgi.uniminas.entidades.Imovel;
import pgi.uniminas.entidades.Visita;

/**
 *
 * @author G1
 */
public interface VisitaDao {

    public List<Visita> getVisitas(Imovel im);

    public void insertVisita(Visita v);

    public void updateVisita(Visita v);

    public void deleteVisita(Visita[] v);
}
