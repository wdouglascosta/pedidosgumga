package br.com.gumga.pedidos.domain.model;
import io.gumga.domain.GumgaModel; //TODO RETIRAR OS IMPORTS DESNECESSÁRIOS
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
@Entity(name = "Produto")
@Table(name = "Produto", indexes = {
    @Index(name = "Produto_gum_oi", columnList = "oi")
})
@SequenceGenerator(name = GumgaModel.SEQ_NAME, sequenceName = "SEQ_Produto")
public class Produto extends GumgaModel<Long> {

	@Column(name = "nome")
	private String nome;

	@Column(name = "quantidade")
	private int quantidade;

	@Column(name = "valor")
	private BigDecimal valor;

    @Version
    @Column(name = "version")
    private Integer version;

    @Column(name = "categoria")
	private Categoria categoria;


	public Produto(GumgaOi oi, String nome, int quantidade, BigDecimal valor, Categoria categoria) {
		super(oi);
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
		this.categoria = categoria;
	}

	public Integer getVersion() {
		return version;
	}

	public String getNome() {

		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Produto() {}

	public Categoria getCategoria() {
		return this.categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
