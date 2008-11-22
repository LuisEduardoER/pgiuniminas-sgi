package pgi.uniminas.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author g1
 */
@Entity
@Table(name = "sgiimovel")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Imovel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codImovel;
    @OneToOne
    @JoinColumn(name = "codcep")
    private Endereco endereco;
    @OneToOne
    @JoinColumn(name = "codPessoa")
    private Pessoa proprietario;
    @Column(name = "numendereco")
    private int numEndereco;
    @Column(name = "descomplementoend")
    private String desComplementoEnd;
    @Column(name = "areautil")
    private double areaUtil;
    @Column(name = "areatotal")
    private double areaTotal;
    @Column(name = "indstatus")
    private char indStatus;
    @Column(name = "valimovel")
    private double valImovel;
    @Column(name = "indtipo")
    private char indTipo;

    public Imovel() {
    }

    public Imovel(Endereco endereco, Pessoa proprietario, int numEndereco,
            String desComplementoEnd, double areaUtil, double areaTotal,
            char indStatus, double valImovel, char indTipo) {
        this.endereco = endereco;
        this.proprietario = proprietario;
        this.numEndereco = numEndereco;
        this.desComplementoEnd = desComplementoEnd;
        this.areaUtil = areaUtil;
        this.areaTotal = areaTotal;
        this.indStatus = indStatus;
        this.valImovel = valImovel;
        this.indTipo = indTipo;
    }

    public int getCodImovel() {
        return codImovel;
    }

    public double getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(double areaTotal) {
        this.areaTotal = areaTotal;
    }

    public double getAreaUtil() {
        return areaUtil;
    }

    public void setAreaUtil(double areaUtil) {
        this.areaUtil = areaUtil;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setCodCep(Endereco endereco) {
        this.endereco = endereco;
    }

    public Pessoa getCodPropietario() {
        return proprietario;
    }

    public void setProprietario(Pessoa proprietario) {
        this.proprietario = proprietario;
    }

    public String getDesComplementoEnd() {
        return desComplementoEnd;
    }

    public void setDesComplementoEnd(String desComplementoEnd) {
        this.desComplementoEnd = desComplementoEnd;
    }

    public char getIndStatus() {
        return indStatus;
    }

    public void setIndStatus(char indStatus) {
        this.indStatus = indStatus;
    }

    public char getIndTipo() {
        return indTipo;
    }

    public void setIndTipo(char indTipo) {
        this.indTipo = indTipo;
    }

    public int getNumEndereco() {
        return numEndereco;
    }

    public void setNumEndereco(int numEndereco) {
        this.numEndereco = numEndereco;
    }

    public double getValImovel() {
        return valImovel;
    }

    public void setValImovel(double valImovel) {
        this.valImovel = valImovel;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Imovel outro = (Imovel) obj;
        if (this.codImovel != outro.codImovel) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.codImovel;
        return hash;
    }

    @Override
    public String toString() {
        return "pgi.uniminas.entidades.Imovel [id=" + codImovel + "]";
    }
}
