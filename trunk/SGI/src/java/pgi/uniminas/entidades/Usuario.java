package pgi.uniminas.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author g1
 */
@Entity
@Table(name = "sgiusuario")
public class Usuario implements Serializable {

    @Id
    @Column(name = "codusuario")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codUsuario;
    @Column(name = "nomusuario")
    private String nomUsuario;
    @Column(name = "nomlogin")
    private String nomLogin;
    @Column(name = "dessenha")
    private String desSenha;
    @Column(name = "deshash")
    private String desHash;
    @Column(name = "indadmin")
    private char indAdmin;
    @Column(name = "dtacadastro")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtaCadastro;
    @Column(name = "dtaultimoacesso")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtaUltimoAcesso;
    @Column(name = "indbloqueado")
    private char indBloqueado;

    public Usuario() {
    }

    public Usuario(String nomUsuario, String nomLogin, String desSenha,
            String desHash, char indAdmin, Date dtaCadastro,
            Date dtaUltimoAcesso, char indBloqueado) {
        this.nomUsuario = nomUsuario;
        this.nomLogin = nomLogin;
        this.desSenha = desSenha;
        this.desHash = desHash;
        this.indAdmin = indAdmin;
        this.dtaCadastro = dtaCadastro;
        this.dtaUltimoAcesso = dtaUltimoAcesso;
        this.indBloqueado = indBloqueado;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public String getDesHash() {
        return desHash;
    }

    public void setDesHash(String desHash) {
        this.desHash = desHash;
    }

    public String getDesSenha() {
        return desSenha;
    }

    public void setDesSenha(String desSenha) {
        this.desSenha = desSenha;
    }

    public Date getDtaCadastro() {
        return dtaCadastro;
    }

    public void setDtaCadastro(Date dtaCadastro) {
        this.dtaCadastro = dtaCadastro;
    }

    public Date getDtaUltimoAcesso() {
        return dtaUltimoAcesso;
    }

    public void setDtaUltimoAcesso(Date dtaUltimoAcesso) {
        this.dtaUltimoAcesso = dtaUltimoAcesso;
    }

    public char getIndAdmin() {
        return indAdmin;
    }

    public void setIndAdmin(char indAdmin) {
        this.indAdmin = indAdmin;
    }

    public char getIndBloqueado() {
        return indBloqueado;
    }

    public void setIndBloqueado(char indBloqueado) {
        this.indBloqueado = indBloqueado;
    }

    public String getNomLogin() {
        return nomLogin;
    }

    public void setNomLogin(String nomLogin) {
        this.nomLogin = nomLogin;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario outro = (Usuario) obj;
        if (this.codUsuario != outro.codUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.codUsuario;
        return hash;
    }

    @Override
    public String toString() {
        return "pgi.uniminas.entidades.Usuario [id=" + codUsuario + "]";
    }
}
