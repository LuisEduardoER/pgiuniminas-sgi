package pgi.uniminas.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author g1
 */
@Entity
@PrimaryKeyJoinColumn(name="codimovel")
@Table(name = "sgiimovelres")
public class ImovelRes extends Imovel implements Serializable {

    @Column(name = "desimovel")
    private String desImovel;
    @Column(name = "dtahabitese")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtaHabitese;
    @Column(name = "indcobertura")
    private char indCobertura;
    @Column(name = "indnovousado")
    private char indNovoUsado;
    @Column(name = "qtddormitorios")
    private int qtdDormitorios;
    @Column(name = "qtdsuite")
    private int qtdSuite;
    @Column(name = "qtdbanheiro")
    private int qtdBanheiro;
    @Column(name = "qtdsala")
    private int qtdSala;
    @Column(name = "qtdvagasgarajem")
    private int qtdVagasGarajem;
    @Column(name = "valcondominio")
    private double valCondominio;
    @Column(name = "indtipores")
    private char indTipoRes;

    public ImovelRes() {
    }

    public ImovelRes(Endereco codCep, Pessoa codPessoa, int numEndereco,
            String desComplementoEnd, double areaUtil, double areaTotal,
            char indStatus, double valImovel, char indTipo, String desImovel,
            Date dtaHabitese, char indCobertura, char indNovoUsado,
            int qtdDormitorios, int qtdSuite, int qtdBanheiro, int qtdSala,
            int qtdVagasGarajem, double valCondominio, char indTipoRes) {
        super(codCep, codPessoa, numEndereco, desComplementoEnd, areaUtil,
                areaTotal, indStatus, valImovel, indTipo);
        this.desImovel = desImovel;
        this.dtaHabitese = dtaHabitese;
        this.indCobertura = indCobertura;
        this.indNovoUsado = indNovoUsado;
        this.qtdDormitorios = qtdDormitorios;
        this.qtdSuite = qtdSuite;
        this.qtdBanheiro = qtdBanheiro;
        this.qtdSala = qtdSala;
        this.qtdVagasGarajem = qtdVagasGarajem;
        this.valCondominio = valCondominio;
        this.indTipoRes = indTipoRes;
    }

    public ImovelRes(String desImovel, Date dtaHabitese, char indCobertura,
            char indNovoUsado, int qtdDormitorios, int qtdSuite,
            int qtdBanheiro, int qtdSala, int qtdVagasGarajem,
            double valCondominio, char indTipoRes) {
        this.desImovel = desImovel;
        this.dtaHabitese = dtaHabitese;
        this.indCobertura = indCobertura;
        this.indNovoUsado = indNovoUsado;
        this.qtdDormitorios = qtdDormitorios;
        this.qtdSuite = qtdSuite;
        this.qtdBanheiro = qtdBanheiro;
        this.qtdSala = qtdSala;
        this.qtdVagasGarajem = qtdVagasGarajem;
        this.valCondominio = valCondominio;
        this.indTipoRes = indTipoRes;
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

    public char getIndCobertura() {
        return indCobertura;
    }

    public void setIndCobertura(char indCobertura) {
        this.indCobertura = indCobertura;
    }

    public char getIndNovoUsado() {
        return indNovoUsado;
    }

    public void setIndNovoUsado(char indNovoUsado) {
        this.indNovoUsado = indNovoUsado;
    }

    public int getQtdBanheiro() {
        return qtdBanheiro;
    }

    public void setQtdBanheiro(int qtdBanheiro) {
        this.qtdBanheiro = qtdBanheiro;
    }

    public int getQtdDormitorios() {
        return qtdDormitorios;
    }

    public void setQtdDormitorios(int qtdDormitorios) {
        this.qtdDormitorios = qtdDormitorios;
    }

    public int getQtdSala() {
        return qtdSala;
    }

    public void setQtdSala(int qtdSala) {
        this.qtdSala = qtdSala;
    }

    public int getQtdSuite() {
        return qtdSuite;
    }

    public void setQtdSuite(int qtdSuite) {
        this.qtdSuite = qtdSuite;
    }

    public int getQtdVagasGarajem() {
        return qtdVagasGarajem;
    }

    public void setQtdVagasGarajem(int qtdVagasGarajem) {
        this.qtdVagasGarajem = qtdVagasGarajem;
    }

    public double getValCondominio() {
        return valCondominio;
    }

    public void setValCondominio(double valCondominio) {
        this.valCondominio = valCondominio;
    }

    public char getIndTipoRes() {
        return indTipoRes;
    }

    public void setIndCasaApto(char indTipoRes) {
        this.indTipoRes = indTipoRes;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ImovelRes outro = (ImovelRes) obj;
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

    @Override
    public String toString() {
        return "pgi.uniminas.entidades.ImovelRes [id=" + super.getCodImovel() + "]";
    }
}
