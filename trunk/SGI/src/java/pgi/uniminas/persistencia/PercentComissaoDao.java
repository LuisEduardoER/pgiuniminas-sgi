package pgi.uniminas.persistencia;

import java.util.List;
import pgi.uniminas.entidades.PercentComissao;

/**
 *
 * @author G1
 */
public interface PercentComissaoDao {

    public List<PercentComissao> getPercentComissoes();

    public PercentComissao getPercentComissao(int codCorretor);

    public void insertPercentComissao(PercentComissao p);

    public void updatePercentComissao(PercentComissao p);

    public void deletePercentComissao(PercentComissao p);
}
