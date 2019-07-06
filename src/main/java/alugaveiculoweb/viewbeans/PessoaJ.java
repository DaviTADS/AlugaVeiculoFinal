/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alugaveiculoweb.viewbeans;

import alugaveiculoweb.beans.PessoaFisicaBean;
import alugaveiculoweb.beans.PessoaJuridicaBean;
import alugaveiculoweb.beans.VeiculoBean;
import alugaveiculoweb.entidades.PessoaFisica;
import alugaveiculoweb.entidades.PessoaJuridica;
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
public class PessoaJ implements Serializable {

    
    
     @Inject
     private PessoaJuridicaBean pessoajbean;
     protected PessoaJuridica pj;
     
     @PostConstruct
    public void init() {
        iniciarCampos();
    }
     
     public void iniciarCampos() {
        setPf(pessoajbean.criarPessoaj());
    }
     
     public boolean Persistir(PessoaJuridica pessoaj){
        pessoajbean.persistirPessoaJ(pessoaj);
       return true;
    }
     
    public void Salvar(){
        Persistir(pj);
    } 

    public PessoaJuridica getPj() {
        return pj;
    }

    public void setPf(PessoaJuridica pj) {
        this.pj = pj;
    }

    public PessoaJuridicaBean getPessoajbean() {
        return pessoajbean;
    }

    public void setPessoajbean(PessoaJuridicaBean pessoajbean) {
        this.pessoajbean = pessoajbean;
    }
     
    
    
}

