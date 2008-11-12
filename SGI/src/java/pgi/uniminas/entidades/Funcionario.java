package pgi.uniminas.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author g1
 */
@Entity
@Table(name = "sgifuncionario")
public class Funcionario extends Pessoa implements Serializable {

    @Column(name = "nummatricula")
    private int numMatricula;
    @Column(name = "desfuncao")
    private String desFuncao;

    public Funcionario() {
    }

    public Funcionario(String nomPessoa, char indNatureza, String numCpfCnpj,
            String numIeRg, char indCliente, char indCorretor,
            char indFuncionario, Endereco codCep, int numEndereco,
            String desComplemento, String numTelefoneCom,
            String numTelefoneRes, String numTelefoneCel,
            String numTelefoneFax, String email, Date dtaNascimento,
            String nomFantasia, String nomContato, int numMatricula,
            String desFuncao) {
        super(nomPessoa, indNatureza, numCpfCnpj, numIeRg, indCliente,
                indCorretor, indFuncionario, codCep, numEndereco, desComplemento,
                numTelefoneCom, numTelefoneRes, numTelefoneCel, numTelefoneFax,
                email, dtaNascimento, nomFantasia, nomContato);
        this.numMatricula = numMatricula;
        this.desFuncao = desFuncao;
    }

    public Funcionario(int numMatricula, String desFuncao) {
        this.numMatricula = numMatricula;
        this.desFuncao = desFuncao;
    }

    public String getDesFuncao() {
        return desFuncao;
    }

    public void setDesFuncao(String desFuncao) {
        this.desFuncao = desFuncao;
    }

    public int getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Funcionario)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario outro = (Funcionario) obj;
        if (this.numMatricula != outro.numMatricula) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.numMatricula;
        return hash;
    }

    @Override
    public String toString() {
        return "pgi.uniminas.entidades.Funcionario [id=" + super.getCodPessoa() + "]";
    }
}
