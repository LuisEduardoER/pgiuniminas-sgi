package pgi.uniminas.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author g1
 */
@Entity
@Table(name="sgiusuariopermissao")
public class UsuarioPermissao implements Serializable{
    @Id    
    @ManyToOne
    @JoinColumn(name="codusuario")
    private Usuario usuario;
    @Id
    @ManyToOne
    @JoinColumn(name="codacao")
    private ContextoAcao contextoAcao;

    public UsuarioPermissao() {
    }

    public UsuarioPermissao(Usuario usuario, ContextoAcao contextoAcao) {
        this.usuario = usuario;
        this.contextoAcao = contextoAcao;
    }

    public ContextoAcao getContextoAcao() {
        return contextoAcao;
    }

    public void setContextoAcao(ContextoAcao contextoAcao) {
        this.contextoAcao = contextoAcao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuarioPermissao outro = (UsuarioPermissao) obj;
        if (usuario == null || !usuario.equals(outro)) {
            return false;
        }
        if (contextoAcao == null || !contextoAcao.equals(outro)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.usuario != null ? this.usuario.hashCode() : 0);
        hash = 59 * hash + (this.contextoAcao != null ? this.contextoAcao.hashCode() : 0);
        return hash;
    }
    
    @Override
    public String toString(){
        return "pgi.uniminas.entidades.UsuarioPermissao [Usuario id=" +
                usuario.getCodUsuario() + "] [Contexto id=" +
                contextoAcao.getCodAcao()+"]"; 
    }
    
    
}