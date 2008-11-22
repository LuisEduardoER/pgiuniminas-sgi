package pgi.uniminas.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author g1
 */
@Entity
@Table(name = "sgicontexto")
public class Contexto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="codcontexto")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codContexto;
    @OneToOne
    @JoinColumn(name = "codusuario")
    private Usuario usuario;
    @Column(name = "nomgrupo")
    private String nomGrupo;
    @Column(name = "indadmin")
    private char indAdmin;
    @Column(name = "desurl")
    private String desUrl;
    @Column(name = "indmenu")
    private char indMenu;
    @Column(name = "nomtabela")
    private String nomTabela;
    @OneToOne
    @JoinColumn(name = "codcontexto")
    private Contexto contexto;
    @OneToOne(mappedBy="contexto")
    private ContextoAcao contextoAcao;

    public Contexto() {
    }

    public Contexto(Usuario usuario, String nomGrupo, char indAdmin,
            String desUrl, char indMenu, String nomTabela, Contexto contexto) {
        this.usuario = usuario;
        this.nomGrupo = nomGrupo;
        this.indAdmin = indAdmin;
        this.desUrl = desUrl;
        this.indMenu = indMenu;
        this.nomTabela = nomTabela;
        this.contexto = contexto;
    }

    public int getCodContexto() {
        return codContexto;
    }

    public Contexto getContexto() {
        return contexto;
    }

    public void setContexto(Contexto contexto) {
        this.contexto = contexto;
    }

    public String getDesUrl() {
        return desUrl;
    }

    public void setDesUrl(String desUrl) {
        this.desUrl = desUrl;
    }

    public char getIndAdmin() {
        return indAdmin;
    }

    public void setIndAdmin(char indAdmin) {
        this.indAdmin = indAdmin;
    }

    public char getIndMenu() {
        return indMenu;
    }

    public void setIndMenu(char indMenu) {
        this.indMenu = indMenu;
    }

    public String getNomGrupo() {
        return nomGrupo;
    }

    public void setNomGrupo(String nomGrupo) {
        this.nomGrupo = nomGrupo;
    }

    public String getNomTabela() {
        return nomTabela;
    }

    public void setNomTabela(String nomTabela) {
        this.nomTabela = nomTabela;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ContextoAcao getContextoAcao() {
        return contextoAcao;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contexto outro = (Contexto) obj;
        if (this.codContexto != outro.codContexto) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.codContexto;
        return hash;
    }

    @Override
    public String toString() {
        return "pgi.uniminas.entidades.Visita[id=" + codContexto + "]";
    }
}
