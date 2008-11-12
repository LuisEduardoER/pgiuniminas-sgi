package pgi.uniminas.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;

/**
 * @author g1
 */
@Entity
@Table(name = "sgipessoa")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Pessoa implements Serializable {

    @Id
    @Column(name = "codpessoa")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codPessoa;
    @Column(name = "nompessoa")
    private String nomPessoa;
    @Column(name = "indnatureza")
    private char indNatureza;
    @Column(name = "numcpfcnpj")
    private String numCpfCnpj;
    @Column(name = "numierg")
    private String numIeRg;
    @Column(name = "indcliente")
    private char indCliente;
    @Column(name = "indcorretor")
    private char indCorretor;
    @Column(name = "indfuncionario")
    private char indFuncionario;
    @OneToOne
    @JoinColumn(name = "codCep")
    private Endereco endereco;
    @Column(name = "numendereco")
    private int numEndereco;
    @Column(name = "descomplemento")
    private String desComplemento;
    @Column(name = "numtelefonecom")
    private String numTelefoneCom;
    @Column(name = "numtelefoneres")
    private String numTelefoneRes;
    @Column(name = "numtelefonecel")
    private String numTelefoneCel;
    @Column(name = "numtelefonefax")
    private String numTelefoneFax;
    @Column(name = "email")
    private String email;
    @Column(name = "dtanascimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtaNascimento;
    @Column(name = "nomfantasia")
    private String nomFantasia;
    @Column(name = "nomcontato")
    private String nomContato;

    public Pessoa() {
    }

    public Pessoa(String nomPessoa, char indNatureza, String numCpfCnpj,
            String numIeRg, char indCliente, char indCorretor,
            char indFuncionario, Endereco endereco, int numEndereco,
            String desComplemento, String numTelefoneCom,
            String numTelefoneRes, String numTelefoneCel,
            String numTelefoneFax, String email, Date dtaNascimento,
            String nomFantasia, String nomContato) {
        this.nomPessoa = nomPessoa;
        this.indNatureza = indNatureza;
        this.numCpfCnpj = numCpfCnpj;
        this.numIeRg = numIeRg;
        this.indCliente = indCliente;
        this.indCorretor = indCorretor;
        this.indFuncionario = indFuncionario;
        this.endereco = endereco;
        this.numEndereco = numEndereco;
        this.desComplemento = desComplemento;
        this.numTelefoneCom = numTelefoneCom;
        this.numTelefoneRes = numTelefoneRes;
        this.numTelefoneCel = numTelefoneCel;
        this.numTelefoneFax = numTelefoneFax;
        this.email = email;
        this.dtaNascimento = dtaNascimento;
        this.nomFantasia = nomFantasia;
        this.nomContato = nomContato;
    }

    public int getCodPessoa() {
        return codPessoa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setCodCep(Endereco codCep) {
        this.endereco = codCep;
    }

    public String getDesComplemento() {
        return desComplemento;
    }

    public void setDesComplemento(String desComplemento) {
        this.desComplemento = desComplemento;
    }

    public Date getDtaNascimento() {
        return dtaNascimento;
    }

    public void setDtaNascimento(Date dtaNascimento) {
        this.dtaNascimento = dtaNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getIndCliente() {
        return indCliente;
    }

    public void setIndCliente(char indCliente) {
        this.indCliente = indCliente;
    }

    public char getIndCorretor() {
        return indCorretor;
    }

    public void setIndCorretor(char indCorretor) {
        this.indCorretor = indCorretor;
    }

    public char getIndFuncionario() {
        return indFuncionario;
    }

    public void setIndFuncionario(char indFuncionario) {
        this.indFuncionario = indFuncionario;
    }

    public char getIndNatureza() {
        return indNatureza;
    }

    public void setIndNatureza(char indNatureza) {
        this.indNatureza = indNatureza;
    }

    public String getNomContato() {
        return nomContato;
    }

    public void setNomContato(String nomContato) {
        this.nomContato = nomContato;
    }

    public String getNomFantasia() {
        return nomFantasia;
    }

    public void setNomFantasia(String nomFantasia) {
        this.nomFantasia = nomFantasia;
    }

    public String getNomPessoa() {
        return nomPessoa;
    }

    public void setNomPessoa(String nomPessoa) {
        this.nomPessoa = nomPessoa;
    }

    public String getNumCpfCnpj() {
        return numCpfCnpj;
    }

    public void setNumCpfCnpj(String numCpfCnpj) {
        this.numCpfCnpj = numCpfCnpj;
    }

    public int getNumEndereco() {
        return numEndereco;
    }

    public void setNumEndereco(int numEndereco) {
        this.numEndereco = numEndereco;
    }

    public String getNumIeRg() {
        return numIeRg;
    }

    public void setNumIeRg(String numIeRg) {
        this.numIeRg = numIeRg;
    }

    public String getNumTelefoneCel() {
        return numTelefoneCel;
    }

    public void setNumTelefoneCel(String numTelefoneCel) {
        this.numTelefoneCel = numTelefoneCel;
    }

    public String getNumTelefoneCom() {
        return numTelefoneCom;
    }

    public void setNumTelefoneCom(String numTelefoneCom) {
        this.numTelefoneCom = numTelefoneCom;
    }

    public String getNumTelefoneFax() {
        return numTelefoneFax;
    }

    public void setNumTelefoneFax(String numTelefoneFax) {
        this.numTelefoneFax = numTelefoneFax;
    }

    public String getNumTelefoneRes() {
        return numTelefoneRes;
    }

    public void setNumTelefoneRes(String numTelefoneRes) {
        this.numTelefoneRes = numTelefoneRes;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa outro = (Pessoa) obj;
        if (this.codPessoa != outro.codPessoa) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.codPessoa;
        return hash;
    }

    @Override
    public String toString() {
        return "pgi.uniminas.entidades.Pessoa [id=" + codPessoa + "]";
    }
}
