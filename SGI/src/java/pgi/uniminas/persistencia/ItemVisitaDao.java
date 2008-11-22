package pgi.uniminas.persistencia;

import java.util.List;
import pgi.uniminas.entidades.ItemVisita;
import pgi.uniminas.entidades.Visita;

/**
 *
 * @author G1
 */
public interface ItemVisitaDao {

    public List<ItemVisita> getItensVisita(Visita v);

    public void insertItemVisita(ItemVisita i);

    public void updateItemVisita(ItemVisita i);

    public void deleteItemVisita(ItemVisita[] iV);
}
