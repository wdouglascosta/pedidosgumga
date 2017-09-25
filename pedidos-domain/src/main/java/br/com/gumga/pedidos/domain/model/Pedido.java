package br.com.gumga.pedidos.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.gumga.domain.GumgaModel;
import io.gumga.domain.GumgaMultitenancy;
import io.gumga.domain.domains.GumgaOi;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@GumgaMultitenancy
@Audited
@Entity(name = "Pedido")
@Table(name = "pedido", indexes = {
    @Index(name = "Pedido_gum_oi", columnList = "oi")
})
@SequenceGenerator(name = GumgaModel.SEQ_NAME, sequenceName = "SEQ_Pedido")
public class Pedido extends GumgaModel<Long> {

    @Version
    @Column(name = "version")
    private Integer version;

    @OneToMany
  //  @JsonIgnoreProperties({"pedido"})
    private List<ItemPedido> itens;

    @ManyToOne
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private TipoOperacao tipoOperacao;

    public Pedido() {
    }

    public Pedido(List<ItemPedido> itens, Cliente cliente, TipoOperacao tipoOperacao) {
        this.itens = itens;
        this.cliente = cliente;
        this.tipoOperacao = tipoOperacao;
    }

    public Pedido(List<ItemPedido> itens, Cliente cliente) {
        this.itens = itens;
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoOperacao getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(TipoOperacao tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }
}
