/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alugaveiculoweb.viewbeans;

import alugaveiculoweb.beans.PessoaFisicaBean;
import alugaveiculoweb.beans.VeiculoBean;
import alugaveiculoweb.entidades.PessoaFisica;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author davi
 */

@RequestScoped
@Named
public class PessoaF implements Serializable {

    
    
     @Inject
     private PessoaFisicaBean pessoafbean;
     protected PessoaFisica pf;
     
     @PostConstruct
    public void init() {
        iniciarCampos();
    }
     
     public void iniciarCampos() {
        setPf(pessoafbean.criarPessoaf());
    }
     
     public boolean Persistir(PessoaFisica pessoaf){
        pessoafbean.persistirPessoaF(pessoaf);
       return true;
    }
     
    public void Salvar(){
        Persistir(pf);
    } 

    public PessoaFisica getPf() {
        return pf;
    }

    public void setPf(PessoaFisica pf) {
        this.pf = pf;
    }
     
    public PessoaFisicaBean getPessoafbean() {
        return pessoafbean;
    }

    public void setPessoafbean(PessoaFisicaBean pessoafbean) {
        this.pessoafbean = pessoafbean;
    }
    
}
