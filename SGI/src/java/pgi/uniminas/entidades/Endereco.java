package pgi.uniminas.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author g1
 */
@Entity
@Table(name = "sgiendereco")
public class Endereco implements Serializable {

    @Id
    @Column(name = "codcep")
    private String codCep;
    @Column(name = "nomlogradouro")
    private String nomLogradouro;
    @Column(name = "nombairro")
    private String nomBairo;
    @Column(name = "nomcidade")
    private String nomCidade;
    @Column(name = "sglestado")
    private String sglEstado;
    @Column(name = "desobservacao")
    private String desObservacao;
    @Column(name = "indtipolougradouro")
    private String indTipoLogradouro;
    

    public Endereco() {
    }

    public Endereco(String codCep, String nomLogradouro, String nomBairo,
            String nomCidade, String sglEstado, String desObservacao,
            String indTipoLogradouro) {
        this.codCep = codCep;
        this.nomLogradouro = nomLogradouro;
        this.nomBairo = nomBairo;
        this.nomCidade = nomCidade;
        this.sglEstado = sglEstado;
        this.desObservacao = desObservacao;
        this.indTipoLogradouro = indTipoLogradouro;
    }

    public String getCodCep() {
        return codCep;
    }

    public void setCodCep(String codCep) {
        this.codCep = codCep;
    }

    public String getDesObservacao() {
        return desObservacao;
    }

    public void setDesObservacao(String desObservacao) {
        this.desObservacao = desObservacao;
    }

    public String getIndTipoLogradouro() {
        return indTipoLogradouro;
    }

    public void setIndTipoLogradouro(String indTipoLogradouro) {
        this.indTipoLogradouro = indTipoLogradouro;
    }

    public String getNomBairo() {
        return nomBairo;
    }

    public void setNomBairo(String nomBairo) {
        this.nomBairo = nomBairo;
    }

    public String getNomCidade() {
        return nomCidade;
    }

    public void setNomCidade(String nomCidade) {
        this.nomCidade = nomCidade;
    }

    public String getNomLogradouro() {
        return nomLogradouro;
    }

    public void setNomLogradouro(String nomLogradouro) {
        this.nomLogradouro = nomLogradouro;
    }

    public String getSglEstado() {
        return sglEstado;
    }

    public void setSglEstado(String sglEstado) {
        this.sglEstado = sglEstado;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Endereco outro = (Endereco) obj;
        if (this.codCep == null || !this.codCep.equalsIgnoreCase(outro.codCep)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (this.codCep != null ? this.codCep.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "pgi.uniminas.entidades.Endereco [id=" + codCep + "]";
    }
}
