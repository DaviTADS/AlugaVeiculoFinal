
package alugaveiculoweb.beans;

import alugaveiculoweb.entidades.PessoaFisica;
import javax.annotation.security.PermitAll;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.SUPPORTS;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static javax.persistence.PersistenceContextType.TRANSACTION;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;

@Stateless(name = "PessoafBean")
@LocalBean  
@ValidateOnExecution(type = ExecutableType.ALL)
public class PessoaFisicaBean {
    
    
    @PersistenceContext(name = "AlugaVeiculoWeb", type = TRANSACTION)
    protected EntityManager em;
    
    public boolean existePessoaF(@NotNull PessoaFisica pessoaf){
    TypedQuery<PessoaFisica> query
                = em.createNamedQuery(PessoaFisica.PessoaFporCpf, PessoaFisica.class);    
        query.setParameter(1, pessoaf.getCpf());
        return !query.getResultList().isEmpty();
    }
    
    //@PermitAll
    public void persistirPessoaF(PessoaFisica pessoaf) {

        em.persist(pessoaf);
    }
    
    @TransactionAttribute(SUPPORTS)
    //@PermitAll
    public PessoaFisica criarPessoaf() {

        return new PessoaFisica();
    }
    
    public PessoaFisica atualizaPessoaF(PessoaFisica pessoaf) {

        pessoaf = em.merge(pessoaf);
        em.flush();
        return pessoaf;
    }
    
    public PessoaFisica consultarPessoaFPorId(@NotNull Long id) {
        PessoaFisica pessoaf = em.find(PessoaFisica.class, id);
        System.out.println(pessoaf.getNome());
        return pessoaf;
        
    }
    
    public String imprimeNome(@NotNull Long id){
        PessoaFisica pessoaf = em.find(PessoaFisica.class, id);
        
        return pessoaf.getNome();
        
    }
    
    
}
