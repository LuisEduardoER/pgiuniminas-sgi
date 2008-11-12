/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pgi.uniminas.acoes;

import pgi.uniminas.entidades.Pessoa;
import pgi.uniminas.negocio.PessoaNeg;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author G1
 */
public class PessoaAcao extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private PessoaNeg pessoaNeg = new PessoaNeg();
}