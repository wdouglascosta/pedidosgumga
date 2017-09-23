package br.com.gumga.pedidos.application.service;

import br.com.gumga.pedidos.application.repository.PedidoRepository;
import br.com.gumga.pedidos.domain.model.Cliente;
import br.com.gumga.pedidos.domain.model.Pedido;
import io.gumga.application.GumgaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import org.hibernate.Hibernate;

@Service
@Transactional
public class PedidoService extends GumgaService<Pedido, Long> {

    private final static Logger LOG = LoggerFactory.getLogger(PedidoService.class);
    private final PedidoRepository repository;

    @Autowired
    public PedidoService(PedidoRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Transactional
    public List<Pedido> saveAll(List<Pedido> pedidos) {
        return repository.save(pedidos);
    }

    public boolean hasData() {
        return repository.count() > 0;
    }

    @Transactional
    public Pedido loadPedidoFat(Long id) {
        Pedido obj = view(id);
        Hibernate.initialize(obj.getItens());
        return obj;
    }
}
