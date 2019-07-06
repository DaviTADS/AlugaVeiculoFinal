/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alugaveiculoweb.viewbeans;

import alugaveiculoweb.beans.MotoristaBean;
import alugaveiculoweb.beans.VeiculoBean;
import alugaveiculoweb.entidades.Motorista;
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
public class MotoristaB implements Serializable{
    
    @Inject
     private MotoristaBean motoristabean;
     private Motorista mot;

     @PostConstruct
    public void init() {
        iniciarCampos();
    }  
    
    public void iniciarCampos() {
        setMot(motoristabean.criarMotorista());
    }
     
     public boolean Persistir(Motorista motorista){
        motoristabean.persistirMotorista(motorista);
       return true;
    }
     
    public void Salvar(){
        Persistir(mot);
    } 
    
    public void consultaMotorista(){
        
        mot = motoristabean.consultarMotoristaPorId(1L);
        
    }

    public MotoristaBean getMotoristabean() {
        return motoristabean;
    }

    public void setMotoristabean(MotoristaBean motoristabean) {
        this.motoristabean = motoristabean;
    }

    public Motorista getMot() {
        return mot;
    }

    public void setMot(Motorista mot) {
        this.mot = mot;
    }
    
}
