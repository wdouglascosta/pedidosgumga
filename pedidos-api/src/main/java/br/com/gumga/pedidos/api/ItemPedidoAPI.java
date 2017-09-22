package br.com.gumga.pedidos.api;

import br.com.gumga.pedidos.application.service.ItemPedidoService;
import br.com.gumga.pedidos.domain.model.ItemPedido;
import io.gumga.presentation.GumgaAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/itempedido")
@Transactional
public class ItemPedidoAPI extends GumgaAPI<ItemPedido, Long> {

    @Autowired
    public ItemPedidoAPI(ItemPedidoService service) {
        super(service);
    }
}
