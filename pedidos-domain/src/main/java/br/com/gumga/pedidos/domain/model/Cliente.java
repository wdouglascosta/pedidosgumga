package br.com.gumga.pedidos.domain.model;
import io.gumga.domain.GumgaModel; //TODO RETIRAR OS IMPORTS DESNECESS�RIOS
import io.gumga.domain.GumgaMultitenancy;
import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.*;
import io.gumga.domain.domains.*;
import org.hibernate.annotations.Columns;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.envers.Audited;
import com.fasterxml.jackson.annotation.JsonIgnore;

@GumgaMultitenancy
@Audited
@Entity(name = "Cliente")
@Table(name = "cliente", indexes = {
    @Index(name = "Cliente_gum_oi", columnList = "oi")
})
@SequenceGenerator(name = GumgaModel.SEQ_NAME, sequenceName = "SEQ_Cliente")
public class Cliente extends GumgaModel<Long> {

    @Version
    @Column(name = "version")
    private Integer version;

    @Column(name = "cidade")
	private String cidade;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<GrupoClientes> grupoClientes;

    public Cliente(String cidade, List<GrupoClientes> grupoClientes, GumgaOi oi) {
        super(oi);
        this.cidade = cidade;
        this.grupoClientes = grupoClientes;
    }

        
    
    public List<GrupoClientes> getGrupoClientes() {
        return grupoClientes;
    }

    public void setGrupoClientes(List<GrupoClientes> grupoClientes) {
        this.grupoClientes = grupoClientes;
    }
    
    
    
    public Cliente() {}

	public String getCidade() {
		return this.cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}
