package br.com.gumga.pedidos.seed;

import br.com.gumga.pedidos.application.service.ClienteService;
import br.com.gumga.pedidos.application.service.ItemPedidoService;
import br.com.gumga.pedidos.application.service.PedidoService;
import br.com.gumga.pedidos.application.service.ProdutoService;
import br.com.gumga.pedidos.domain.model.*;
import io.gumga.core.QueryObject;
import io.gumga.domain.domains.GumgaOi;
import io.gumga.domain.seed.AppSeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class PedidoSeed implements AppSeed {

    private final static Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

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
        if (pedidoService.hasData()) {
            LOG.info("Data found, skip " + LOG.getName());
            return;
        }
        QueryObject qo = new QueryObject();
        qo.setPageSize(100000);
        
        List<Cliente> clientes = clienteService.pesquisa(qo).getValues();
        List<Produto> produtos = produtoService.pesquisa(qo).getValues();

        for (int i = 0; i < 100; i++) {

            Pedido p = new Pedido();
            p.setCliente(clientes.get(VicAutoSeed.getRandomInteger(0, clientes.size())));
            p.setItens(new ArrayList<>());

            p.setTipoOperacao(TipoOperacao.COMPRA);

            Integer nProdutos = VicAutoSeed.getRandomInteger(5,10);

            for (int j=0;j<nProdutos;j++) {

                ItemPedido ip = new ItemPedido();

                ip.setQuantidade(VicAutoSeed.getRandomInteger(1,10));
                ip.setProduto(produtos.get(VicAutoSeed.getRandomInteger(0, produtos.size())));
                VicAutoSeed.randomFill(ip);
                p.getItens().add(ip);
            }
            pedidoService.save(p);
        }
    }
}
