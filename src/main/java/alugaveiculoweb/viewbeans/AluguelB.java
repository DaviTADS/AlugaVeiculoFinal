/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alugaveiculoweb.viewbeans;

import alugaveiculoweb.beans.AluguelBean;
import alugaveiculoweb.beans.MotoristaBean;
import alugaveiculoweb.entidades.Aluguel;
import alugaveiculoweb.entidades.Motorista;
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
public class AluguelB implements Serializable{
    
    @Inject
     private AluguelBean aluguelbean;
     protected Aluguel alu;

    

     @PostConstruct
    public void init() {
        iniciarCampos();
    }  
    
    public void iniciarCampos() {
        setAlu(aluguelbean.criarAluguel());
    }
     
     public boolean Persistir(Aluguel aluguel){
        aluguelbean.persistirAluguel(aluguel);
       return true;
    }
     
    public void Salvar(){
        Persistir(alu);
    } 
    
    public AluguelBean getAluguelbean() {
        return aluguelbean;
    }

    public void setAluguelbean(AluguelBean aluguelbean) {
        this.aluguelbean = aluguelbean;
    }

    public Aluguel getAlu() {
        return alu;
    }

    public void setAlu(Aluguel alu) {
        this.alu = alu;
    }
    
}
