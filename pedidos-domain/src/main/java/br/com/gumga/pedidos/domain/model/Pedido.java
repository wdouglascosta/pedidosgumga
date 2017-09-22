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
@Table(name = "Pedido", indexes = {
    @Index(name = "Pedido_gum_oi", columnList = "oi")
})
@SequenceGenerator(name = GumgaModel.SEQ_NAME, sequenceName = "SEQ_Pedido")
public class Pedido extends GumgaModel<Long> {
    @Version
    @Column(name = "version")
    private Integer version;

    @OneToMany
	@JsonIgnoreProperties({"pedido"})
    private List<ItemPedido> itens;

    @OneToOne
    private Cliente clientes;

    public Pedido() {}

    public Pedido(GumgaOi oi, List<ItemPedido> itens, Cliente clientes) {
        super(oi);
        this.itens = itens;
        this.clientes = clientes;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public Cliente getCliente() {
        return clientes;
    }

    public void setCliente(Cliente cliente) {
        this.clientes = cliente;
    }
}
