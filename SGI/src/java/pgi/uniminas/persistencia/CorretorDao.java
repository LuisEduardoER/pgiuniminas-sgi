package pgi.uniminas.persistencia;

import java.util.List;
import pgi.uniminas.entidades.Corretor;

/**
 *
 * @author G1
 */
public interface CorretorDao {

    public List<Corretor> getCorretores();

    public Corretor getCorretor(int codCorretor);

    public void insertCorretor(Corretor cor);

    public void updateCorretor(Corretor cor);

    public void deleteCorrtor(Corretor[] cor);
}
