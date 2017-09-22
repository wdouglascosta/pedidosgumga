package br.com.gumga.pedidos.seed;

import br.com.gumga.pedidos.application.service.ItemPedidoService;
import br.com.gumga.pedidos.domain.model.ItemPedido;
import io.gumga.domain.domains.GumgaOi;
import io.gumga.domain.seed.AppSeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ItemPedidoSeed implements AppSeed{

    @Autowired
    private ItemPedidoService itemPedidoService;

    @Override
    public void loadSeed() throws IOException {
        if (itemPedidoService.exists()){
            return;
        }

        ItemPedido itemPedido1 = new ItemPedido(GumgaOi.MARK_PUBLIC,5,null,null);

        itemPedidoService.save(itemPedido1);


        //HOT FIX
        
    }
}
