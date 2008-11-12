package pgi.uniminas.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author g1
 */
@Entity
@Table(name = "sgiimovelcom")
public class ImovelCom extends Imovel implements Serializable {

    @Column(name = "desimovel")
    private String desImovel;
    @Column(name = "dtahabitese")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtaHabitese;
    @Column(name = "indnovousado")
    private char indNovoUsado;
    @Column(name = "indavenidacom")
    private char indAvenidaCom;
    @Column(name = "indgaleriacom")
    private char indGaleriaCom;
    @Column(name = "qtdvagasest")
    private int qtdVagasEstac;

    public ImovelCom() {
    }

    public ImovelCom(Endereco codCep, Pessoa codPessoa, int numEndereco,
            String desComplementoEnd, double areaUtil, double areaTotal,
            char indStatus, double valImovel, char indTipo,
            String desImovel, Date dtaHabitese, char indNovoUsado,
            char indAvenidaCom, char indGaleriaCom, int qtdVagasEstac) {
        super(codCep, codPessoa, numEndereco, desComplementoEnd, areaUtil,
                areaTotal, indStatus, valImovel, indTipo);
        this.desImovel = desImovel;
        this.dtaHabitese = dtaHabitese;
        this.indNovoUsado = indNovoUsado;
        this.indAvenidaCom = indAvenidaCom;
        this.indGaleriaCom = indGaleriaCom;
        this.qtdVagasEstac = qtdVagasEstac;
    }

    public ImovelCom(String desImovel, Date dtaHabitese, char indNovoUsado,
            char indAvenidaCom, char indGaleriaCom, int qtdVagasEstac) {
        this.desImovel = desImovel;
        this.dtaHabitese = dtaHabitese;
        this.indNovoUsado = indNovoUsado;
        this.indAvenidaCom = indAvenidaCom;
        this.indGaleriaCom = indGaleriaCom;
        this.qtdVagasEstac = qtdVagasEstac;
    }

    public String getDesImovel() {
        return desImovel;
    }

    public void setDesImovel(String desImovel) {
        this.desImovel = desImovel;
    }

    public Date getDtaHabitese() {
        return dtaHabitese;
    }

    public void setDtaHabitese(Date dtaHabitese) {
        this.dtaHabitese = dtaHabitese;
    }

    public char getIndAvenidaCom() {
        return indAvenidaCom;
    }

    public void setIndAvenidaCom(char indAvenidaCom) {
        this.indAvenidaCom = indAvenidaCom;
    }

    public char getIndGaleriaCom() {
        return indGaleriaCom;
    }

    public void setIndGaleriaCom(char indGaleriaCom) {
        this.indGaleriaCom = indGaleriaCom;
    }

    public char getIndNovoUsado() {
        return indNovoUsado;
    }

    public void setIndNovoUsado(char indNovoUsado) {
        this.indNovoUsado = indNovoUsado;
    }

    public int getQtdVagasEstac() {
        return qtdVagasEstac;
    }

    public void setQtdVagasEstac(int qtdVagasEstac) {
        this.qtdVagasEstac = qtdVagasEstac;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ImovelCom outro = (ImovelCom) obj;
        if (super.getCodImovel() != outro.getCodImovel()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public String toString() {
        return "pgi.uniminas.entidades.ImovelCom [id=" + super.getCodImovel() + "]";
    }
}
