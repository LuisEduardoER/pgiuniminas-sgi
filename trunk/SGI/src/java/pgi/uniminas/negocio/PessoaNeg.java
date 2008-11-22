package pgi.uniminas.negocio;

import java.util.List;

import pgi.uniminas.entidades.Pessoa;
import pgi.uniminas.persistencia.PessoaDao;
import pgi.uniminas.persistencia.PessoaHibDao;

/**
 *
 * @author G1
 */
public class PessoaNeg implements PessoaDao {

    private PessoaDao dao;

    public PessoaNeg() {
        this.dao = new PessoaHibDao();
    }

    public List getPessoas() {
        return dao.getPessoas();
    }

    public Pessoa getPessoa(int codPessoa) {
        return dao.getPessoa(codPessoa);
    }

    public void insertPessoa(Pessoa p) {
        dao.insertPessoa(p);
    }

    public void updatePessoa(Pessoa p) {
        dao.updatePessoa(p);
    }

    public void deletePessoa(Pessoa[] p) {
        dao.deletePessoa(p);
    }

    }
