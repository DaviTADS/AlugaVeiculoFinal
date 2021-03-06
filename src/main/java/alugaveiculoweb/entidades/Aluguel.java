package alugaveiculoweb.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author davi, davydadriel
 */
@Entity
@Table(name = "TB_Aluguel")
@NamedNativeQueries(
        {
            @NamedNativeQuery(
                    name = Aluguel.AluguelPorPessoa,
                    query = "SELECT a.ID_Aluguel, a.DT_INICIO, a.DT_FINAL, a.TXT_PRECO FROM TB_Aluguel a INNER JOIN TB_Pessoa p ON (a.ID_Pessoa = p.ID_Pessoa)"                    
            )
        }
)
@NamedQueries(
        {
            @NamedQuery(
                    name = Aluguel.AluguelPorDataInicio,
                    query = "Select a FROM Aluguel a WHERE a.datainicio = ?1"
            ),
            @NamedQuery(
                    name = Aluguel.AluguelPorPreco,
                    query = "Select a FROM Aluguel a WHERE a.preco = ?1"
            ),
            @NamedQuery(
                    name = Aluguel.AluguelPorDataFinal,
                    query = "Select a FROM Aluguel a WHERE a.datafinal = ?1"
            )
        }

)
public class Aluguel implements Serializable{

    public static final String AluguelPorDataInicio = "AluguelPorDataInicio";
    public static final String AluguelPorDataFinal = "AluguelPorDataFinal";
    public static final String AluguelPorPreco = "AluguelPorPreco";
    public static final String AluguelPorPessoa = "AluguelPorPessoa";
    
@NotNull  
@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL , optional = false)
@JoinColumn(name = "ID_Pessoa", referencedColumnName = "ID_Pessoa")
private Pessoa pessoa;

@NotNull
@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
@JoinTable(name = "TB_Aluguel_Veiculo", joinColumns = { 
    @JoinColumn(name = "ID_Aluguel")},
        inverseJoinColumns = {
            @JoinColumn(name = "ID_Veiculo")})
private List<Veiculo> veiculos;


@Id
@Column(name = "ID_Aluguel")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Temporal(TemporalType.DATE)
@Column(name = "DT_INICIO", nullable = false)
private Date datainicio;

@Temporal(TemporalType.DATE)
@Column(name = "DT_FINAL", nullable = false)
private Date datafinal;

@NotBlank
@Size(max = 7, min = 5)
@Column(name="TXT_PRECO",length = 20, nullable = false)
private String preco;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatafinal() {
        return datafinal;
    }

    public void setDatafinal(Date datafinal) {
        this.datafinal = datafinal;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

}
