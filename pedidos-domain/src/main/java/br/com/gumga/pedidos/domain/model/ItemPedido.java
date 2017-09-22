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
public class ItemPedido extends GumgaModel<Long>{

    @Version
    @Column(name = "version")
    private Integer version;

    @Column(name = "quantidade")
    private Integer quantidade;

    @ManyToOne
    @JsonIgnoreProperties({"itens"})
    private Pedido pedido;

    @OneToOne
    private Produto produto;

    public ItemPedido() {
    }

    public ItemPedido(GumgaOi oi, Integer quantidade, Pedido pedido, Produto produto) {
        super(oi);
        this.quantidade = quantidade;
        this.pedido = pedido;
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
