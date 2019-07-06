/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alugaveiculoweb.viewbeans;

import alugaveiculoweb.beans.PessoaFisicaBean;
import alugaveiculoweb.beans.VeiculoBean;
import alugaveiculoweb.entidades.PessoaFisica;
import alugaveiculoweb.entidades.Veiculo;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author davi
 */
@RequestScoped
@Named
public class VeiculoB implements Serializable{
    
    
  @Inject
     private VeiculoBean veiculobean;
     protected Veiculo vei;

     @PostConstruct
    public void init() {
        iniciarCampos();
    }  
    
    public void iniciarCampos() {
        setVei(veiculobean.criarVeiculo());
    }
     
     public boolean Persistir(Veiculo veiculo){
        veiculobean.persistirVeiculo(veiculo);
       return true;
    }
     
    public void Salvar(){
        Persistir(vei);
    } 
    
    public VeiculoBean getVeiculobean() {
        return veiculobean;
    }

    public void setVeiculobean(VeiculoBean veiculobean) {
        this.veiculobean = veiculobean;
    }

    public Veiculo getVei() {
        return vei;
    }

    public void setVei(Veiculo vei) {
        this.vei = vei;
    }
    
}
