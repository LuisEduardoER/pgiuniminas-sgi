package pgi.uniminas.acoes;

import java.util.*;

import pgi.uniminas.entidades.Imovel;
import pgi.uniminas.entidades.Endereco;
import pgi.uniminas.negocio.ImovelNeg;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author G1
 */
public class ImovelAcao extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private ImovelNeg imovelNeg = new ImovelNeg();
    private List<Imovel> listImovel;

    public String getImoveis() {
        listImovel = imovelNeg.getImoveis();
        return "Sucess";
    }
}
