package pgi.uniminas.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author g1
 */
@Entity
@PrimaryKeyJoinColumn(name="codimovel")
@Table(name = "sgiimovelout")
public class ImovelOut extends Imovel implements Serializable {

    @Column(name = "desimovel")
    private String desImovel;
    @Column(name = "indesquina")
    private char indEsquina;
    @Column(name = "indquina")
    private char indQuina;
    @Column(name = "indtipoout")
    private char indTipoOut;

    public ImovelOut() {
    }

    public ImovelOut(Endereco codCep, Pessoa codPessoa, int numEndereco,
            String desComplementoEnd, double areaUtil, double areaTotal,
            char indStatus, double valImovel, char indTipo, char indTipoOut,
            String desImovel, char indEsquina, char indQuina) {
        super(codCep, codPessoa, numEndereco, desComplementoEnd, areaUtil,
                areaTotal, indStatus, valImovel, indTipo);
        this.desImovel = desImovel;
        this.indEsquina = indEsquina;
        this.indQuina = indQuina;
        this.indTipoOut = indTipoOut;
    }

    public ImovelOut(String desImovel, char indEsquina, char indQuina,
            char indTipoOut) {
        this.desImovel = desImovel;
        this.indEsquina = indEsquina;
        this.indQuina = indQuina;
        this.indTipoOut = indTipoOut;
    }

    public String getDesImovel() {
        return desImovel;
    }

    public void setDesImovel(String desImovel) {
        this.desImovel = desImovel;
    }

    public char getIndEsquina() {
        return indEsquina;
    }

    public void setIndEsquina(char indEsquina) {
        this.indEsquina = indEsquina;
    }

    public char getIndQuina() {
        return indQuina;
    }

    public void setIndQuina(char indQuina) {
        this.indQuina = indQuina;
    }

    public char getIndTipoOut() {
        return indTipoOut;
    }

    public void setIndTipoOut(char indTipoOut) {
        this.indTipoOut = indTipoOut;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ImovelOut outro = (ImovelOut) obj;
        if (super.getCodImovel() != outro.getCodImovel()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
}
