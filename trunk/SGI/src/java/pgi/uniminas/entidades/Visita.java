package pgi.uniminas.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author g1
 */
@Entity
@Table(name = "sgivisita")
public class Visita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "codvisita")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codVisita;
    @ManyToOne
    @JoinColumn(name = "codimovel")
    private Imovel imovel;
    @Column(name = "dtavisita")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtaVisita;

    public Visita() {
    }

    public Visita(Imovel imovel, Date dtaVisita) {
        this.imovel = imovel;
        this.dtaVisita = dtaVisita;
    }

    public int getcodVisita() {
        return codVisita;
    }

    public Date getDtaVisita() {
        return dtaVisita;
    }

    public void setDtaVisita(Date dtaVisita) {
        this.dtaVisita = dtaVisita;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Visita outro = (Visita) obj;
        if (this.codVisita != outro.codVisita) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.codVisita;
        return hash;
    }

    @Override
    public String toString() {
        return "pgi.uniminas.entidades.Visita[id=" + codVisita + "]";
    }
}
