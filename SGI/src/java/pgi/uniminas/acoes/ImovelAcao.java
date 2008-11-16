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

    public ImovelAcao() {
    }

    public ImovelNeg getImovelNeg() {
        return imovelNeg;
    }

    public void setImovelNeg(ImovelNeg imovelNeg) {
        this.imovelNeg = imovelNeg;
    }

    public List<Imovel> getListImovel() {
        return listImovel;
    }

    public void setListImovel(List<Imovel> listImovel) {
        this.listImovel = listImovel;
    }

    public String insertImovel(Imovel i){
        imovelNeg.insertImovel(i);
        return "Sucess";
    }

    public String getImoveis() {
        listImovel = imovelNeg.getImoveis();
        return "Sucess";
    }

    public String getImovel(int codImovel){
        imovelNeg.getImovel(codImovel);
        return "Sucess";
    }

    public String deleteImovel(Imovel [] i){
        imovelNeg.deleteImovel(i);
        return "Sucess";
    }
}
