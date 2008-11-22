package pgi.uniminas.persistencia;

import java.util.List;
import pgi.uniminas.entidades.ContextoAcao;

/**
 *
 * @author G1
 */
public interface ContextoAcaoDao {

    public List<ContextoAcao> getContextoAcoes();

    public ContextoAcao getContextoAcao(int codContextoAcao);

    public void insertContextoAcao(ContextoAcao cA);

    public void updateContextoAcao(ContextoAcao cA);

    public void deleteContextoAcao(ContextoAcao[] cA);
}
