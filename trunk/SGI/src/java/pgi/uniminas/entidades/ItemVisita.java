package pgi.uniminas.entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author g1
 */
@Entity
@Table(name = "sgiparecervisita")
public class ItemVisita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "seqparecer")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int seqParecer;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "codvisita")
    private Visita visita;
    @Column(name = "indtipo")
    private char indTipo;
    @Column(name = "desparecer")
    private String descricao;

    public ItemVisita() {
    }

    public ItemVisita(Visita visita, char indTipo, String descricao) {
        this.visita = visita;
        this.indTipo = indTipo;
        this.descricao = descricao;
    }

    public int getSeqParecer() {
        return seqParecer;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public char getIndTipo() {
        return indTipo;
    }

    public void setIndTipo(char indTipo) {
        this.indTipo = indTipo;
    }

    public Visita getVisita() {
        return visita;
    }

    public void setVisita(Visita visita) {
        this.visita = visita;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemVisita outro = (ItemVisita) obj;
        if (this.seqParecer != outro.seqParecer) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.seqParecer;
        return hash;
    }

    @Override
    public String toString() {
        return "pgi.uniminas.entidades.ItemVisita[id=" + seqParecer + "]";
    }
}
