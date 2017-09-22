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

    public ItemPedido() {
    }

    public ItemPedido(GumgaOi oi, Integer quantidade, Pedido pedidos) {
        super(oi);
        this.quantidade = quantidade;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
