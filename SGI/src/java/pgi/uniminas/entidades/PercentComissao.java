package pgi.uniminas.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
     * @author g1
 */
@Entity
@Table(name = "sgipercentcomissao")
public class PercentComissao implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "codpessoa")
    private Corretor corretor;
    @Column(name = "percentcomissao")
    private int percentComissao;

    public PercentComissao() {
    }

    public PercentComissao(Corretor corretor, int percentComissao) {
        this.corretor = corretor;
        this.percentComissao = percentComissao;
    }

    public Corretor getCorretor() {
        return corretor;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
    }

    public int getPercentComissao() {
        return percentComissao;
    }

    public void setPercentComissao(int percentComissao) {
        this.percentComissao = percentComissao;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PercentComissao outro = (PercentComissao) obj;
        if (!corretor.equals(outro.getCorretor()) || percentComissao != outro.getPercentComissao()) {
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
        return "pgi.uniminas.entidades.PercentComissao [id=" + corretor.getCodPessoa() + "]";
    }
}
