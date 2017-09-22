package br.com.gumga.pedidos.application.service;

import br.com.gumga.pedidos.application.repository.ItemPedidoRepository;
import br.com.gumga.pedidos.domain.model.ItemPedido;
import io.gumga.application.GumgaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemPedidoService extends GumgaService<ItemPedido, Long> {

    private final ItemPedidoRepository repository;

    @Autowired
    public ItemPedidoService(ItemPedidoRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Transactional
    public List<ItemPedido> saveAll(List<ItemPedido> itemPedidos) {
        return repository.save(itemPedidos);
    }

    @Transactional
    public Boolean exists(){
        return repository.count() > 0;
    }
}
