package pgi.uniminas.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author g1
 */
@Entity
@PrimaryKeyJoinColumn(name="codpessoa")
@Table(name = "sgicorretor")
public class Corretor extends Pessoa implements Serializable {

    @Column(name = "numcreci")
    private String numCreci;

    public Corretor() {
    }

    public Corretor(String numCreci) {
        this.numCreci = numCreci;
    }

    public Corretor(String nomPessoa, char indNatureza, String numCpfCnpj,
            String numIeRg, char indCliente, char indCorretor,
            char indFuncionario, Endereco codCep, int numEndereco,
            String desComplemento, String numTelefoneCom,
            String numTelefoneRes, String numTelefoneCel,
            String numTelefoneFax, String email, Date dtaNascimento,
            String nomFantasia, String nomContato, String numCreci) {
        super(nomPessoa, indNatureza, numCpfCnpj, numIeRg, indCliente,
                indCorretor, indFuncionario, codCep, numEndereco, desComplemento,
                numTelefoneCom, numTelefoneRes, numTelefoneCel, numTelefoneFax,
                email, dtaNascimento, nomFantasia, nomContato);
        this.numCreci = numCreci;
    }

    public String getNumCreci() {
        return numCreci;
    }

    public void setNumCreci(String numCreci) {
        this.numCreci = numCreci;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Corretor other = (Corretor) obj;
        if (!this.numCreci.equalsIgnoreCase(other.numCreci) || this.numCreci == null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (this.numCreci != null ? this.numCreci.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "pgi.uniminas.entidades.Corretor [id=" + super.getCodPessoa() + "]";
    }
}
