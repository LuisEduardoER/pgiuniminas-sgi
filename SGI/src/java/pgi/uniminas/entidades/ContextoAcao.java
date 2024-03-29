package pgi.uniminas.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author g1
 */
@Entity
@Table(name = "sgicontextoacao")
public class ContextoAcao implements Serializable {

    @Id
    @Column(name = "codacao")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codAcao;
    @Column(name = "nomacao")
    private String nomAcao;
    @Column(name = "indadmin")
    private char indAdmin;
    @OneToOne
    @JoinColumn(name="codcontexto")
    private Contexto contexto;

    @ManyToMany
    @JoinTable(name="sgiusuariopermissao",
               joinColumns={@JoinColumn(name="codacao")},
               inverseJoinColumns={@JoinColumn(name="codusuario")})
    @Column(name="codusuario")
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    public ContextoAcao() {
    }

    public ContextoAcao(String nomAcao, char indAdmin) {
        this.nomAcao = nomAcao;
        this.indAdmin = indAdmin;
    }

    public int getCodAcao() {
        return codAcao;
    }

    public char getIndAdmin() {
        return indAdmin;
    }

    public void setIndAdmin(char indAdmin) {
        this.indAdmin = indAdmin;
    }

    public String getNomAcao() {
        return nomAcao;
    }

    public void setNomAcao(String nomAcao) {
        this.nomAcao = nomAcao;
    }

    public Contexto getContexto() {
        return contexto;
    }

    public void setContexto(Contexto contexto) {
        this.contexto = contexto;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios){
        this.usuarios = usuarios;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ContextoAcao outro = (ContextoAcao) obj;
        if (this.codAcao != outro.codAcao) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.codAcao;
        return hash;
    }

    @Override
    public String toString() {
        return "pgi.uniminas.entidades.ContextoAcao[id=" + codAcao + "]";
    }
}
