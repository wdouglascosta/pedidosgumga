package br.com.gumga.pedidos.seed;

import br.com.gumga.pedidos.application.service.PedidoService;
import br.com.gumga.pedidos.domain.model.Pedido;
import io.gumga.domain.domains.GumgaOi;
import io.gumga.domain.seed.AppSeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PedidoSeed implements AppSeed {

    @Autowired
    private PedidoService pedidoService;

    @Override
    public void loadSeed() throws IOException {
        if (pedidoService.exists()){
            return;
        }

        Pedido pedido1 = new Pedido();

        pedidoService.save(pedido1);
    }
}
