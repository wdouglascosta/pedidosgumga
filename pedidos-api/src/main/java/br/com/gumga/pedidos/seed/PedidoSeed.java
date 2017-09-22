package br.com.gumga.pedidos.seed;

import br.com.gumga.pedidos.application.service.ClienteService;
import br.com.gumga.pedidos.application.service.ItemPedidoService;
import br.com.gumga.pedidos.application.service.PedidoService;
import br.com.gumga.pedidos.application.service.ProdutoService;
import br.com.gumga.pedidos.domain.model.Cliente;
import br.com.gumga.pedidos.domain.model.ItemPedido;
import br.com.gumga.pedidos.domain.model.Pedido;
import br.com.gumga.pedidos.domain.model.Produto;
import io.gumga.core.QueryObject;
import io.gumga.domain.domains.GumgaOi;
import io.gumga.domain.seed.AppSeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PedidoSeed implements AppSeed {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ItemPedidoService itemPedidoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    @Override
    public void loadSeed() throws IOException {
        if (pedidoService.exists()){
            return;
        }
        
        Cliente cliente = clienteService.pesquisa(new QueryObject()).getValues().get(0);
        
        Pedido p=new Pedido();
        p.setCliente(cliente);
        p.setItens(new ArrayList<>());
        
        List<Produto> values = produtoService.pesquisa(new QueryObject()).getValues();
        
        for (Produto produto:values){
            ItemPedido ip=new ItemPedido(4, produto);

            p.getItens().add(itemPedidoService.save(ip));
        }
        
        pedidoService.save(p);

    }
}
