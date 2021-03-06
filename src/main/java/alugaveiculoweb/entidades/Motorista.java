package alugaveiculoweb.entidades;


import java.io.Serializable;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author davi, davydadriel
 */
@Entity
@Table(name = "TB_Motorista")
@NamedQueries(
        {
              @NamedQuery(
                    name = Motorista.MotoristaPorReputacao,
                    query = "SELECT m FROM Motorista m WHERE m.reputacao = ?1"
            ) 
//            @NamedQuery(
//                    name = Motorista.MotoristaComVeiculo,
//                    query = "SELECT TXT_SOBRENOME FROM TB_Motorista m INNER JOIN TB_Veiculo v ON (m.ID_Pessoa = v.ID_Motorista)"
//            )
        }
)
@DiscriminatorValue(value="M")
@PrimaryKeyJoinColumn(name="ID_Pessoa", referencedColumnName = "ID_Pessoa")
public class Motorista extends Pessoa implements Serializable {
    
    public static final String MotoristaComVeiculo = "MotoristaComVeiculo";
    public static final String MotoristaPorReputacao = "MotoristaPorReputacao";
    
    @Size(max = 3, min = 1)
    @ElementCollection
    @CollectionTable(name = "TB_Habilitacoes",
            joinColumns = @JoinColumn(name = "ID_Pessoa"))
    //@Basic(fetch = FetchType.LAZY)
    @Column(name = "TXT_Habilitacao", table = "TB_Habilitacoes", nullable = false)
    //@ValidaHabilitacao
    private List<String> habilitacoes;
    
    @NotBlank
    @Size(max = 60)
    @Pattern(regexp = "\\p{Upper}{1}\\p{Lower}+", message = "{com.mycompany.alugaveiculo.Motorista.sobrenome}")
    @Column(name = "TXT_SOBRENOME", length = 60, nullable = false)
    private String sobrenome;
    
    
    @Enumerated(EnumType.STRING)
    @Column(name = "TXT_REPUTACAO", length = 20, nullable = true)
    private Reputacao reputacao;
    
    @NotNull
    @CPF
    @Column(name = "TXT_CPF", nullable = false)
    private String cpf;

    public List<String> getHabilitacoes() {
        return habilitacoes;
    }

    public void setHabilitacoes(List<String> habilitacoes) {
        this.habilitacoes = habilitacoes;
    }
    

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    public Reputacao getReputacao() {
        return reputacao;
    }

    public void setReputacao(Reputacao reputacao) {
        this.reputacao = reputacao;
    }
    
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
