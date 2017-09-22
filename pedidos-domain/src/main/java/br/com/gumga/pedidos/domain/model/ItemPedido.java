package br.com.gumga.pedidos.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.gumga.domain.GumgaModel;
import io.gumga.domain.GumgaMultitenancy;
import io.gumga.domain.domains.GumgaOi;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@GumgaMultitenancy
@Audited
@Entity(name = "ItemPedido")
@Table(name = "ItemPedido", indexes = {
    @Index(name = "ItemPedido_gum_oi", columnList = "oi")
})
@SequenceGenerator(name = GumgaModel.SEQ_NAME, sequenceName = "SEQ_ItemPedio")
public class ItemPedido extends GumgaModel<Long> {

    @Version
    @Column(name = "version")
    private Integer version;

    @Column(name = "quantidade")
    private Integer quantidade;

    @ManyToOne
    private Produto produto;

    public ItemPedido() {
    }

    public ItemPedido(Integer quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
