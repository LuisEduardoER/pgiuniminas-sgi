package pgi.uniminas.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author G1
 */
@Entity
@PrimaryKeyJoinColumn(name="codpessoa")
@Table(name = "sgicliente")
public class Cliente extends Pessoa implements Serializable {

    @Column(name = "indestadocivil")
    private char indEstadoCivil;
    @OneToOne    
    @JoinColumn(name = "codconjuje")
    private Pessoa conjuje;

    public Cliente() {
    }

    public Cliente(String nomPessoa, char indNatureza, String numCpfCnpj,
            String numIeRg, char indCliente, char indCorretor,
            char indFuncionario, Endereco codCep, int numEndereco,
            String desComplemento, String numTelefoneCom,
            String numTelefoneRes, String numTelefoneCel,
            String numTelefoneFax, String email, Date dtaNascimento,
            String nomFantasia, String nomContato, char indEstadoCivil,
            Pessoa conjuje) {
        super(nomPessoa, indNatureza, numCpfCnpj, numIeRg, indCliente,
                indCorretor, indFuncionario, codCep, numEndereco, desComplemento,
                numTelefoneCom, numTelefoneRes, numTelefoneCel, numTelefoneFax,
                email, dtaNascimento, nomFantasia, nomContato);
        this.indEstadoCivil = indEstadoCivil;
        this.conjuje = conjuje;
    }

    public Cliente(char indEstadoCivil, Pessoa conjuje) {
        this.indEstadoCivil = indEstadoCivil;
        this.conjuje = conjuje;
    }

    public Pessoa getConjuje() {
        return conjuje;
    }

    public void setConjuje(Pessoa conjuje) {
        this.conjuje = conjuje;
    }

    public char getIndEstadoCivil() {
        return indEstadoCivil;
    }

    public void setIndEstadoCivil(char indEstadoCivil) {
        this.indEstadoCivil = indEstadoCivil;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente outro = (Cliente) obj;
        if (super.getCodPessoa() != outro.getCodPessoa()) {
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
        return "pgi.uniminas.entidades.Cliente [id=" + super.getCodPessoa() + "]";
    }
}
