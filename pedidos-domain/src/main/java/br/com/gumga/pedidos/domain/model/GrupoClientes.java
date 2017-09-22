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
@Entity(name = "GrupoClientes")
@Table(name = "grupo_clientes", indexes = {
    @Index(name = "GrupoClientes_gum_oi", columnList = "oi")
})
@SequenceGenerator(name = GumgaModel.SEQ_NAME, sequenceName = "SEQ_GrupoClientes")
public class GrupoClientes extends GumgaModel<Long> {

    @Version
    @Column(name = "version")
    private Integer version;
    
    @Column(name ="nomeGrupo")
    private String nomeGrupo;

    @Column(name = "privilegio")
	private String privilegio;

    public GrupoClientes(String nomeGrupo, String privilegio, GumgaOi oi) {
        super(oi);      
        this.nomeGrupo = nomeGrupo;
        this.privilegio = privilegio;
    }
    
    

    public GrupoClientes() {}

	public String getPrivilegio() {
		return this.privilegio;
	}
	public void setPrivilegio(String privilegio) {
		this.privilegio = privilegio;
	}

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }
        
        
}
