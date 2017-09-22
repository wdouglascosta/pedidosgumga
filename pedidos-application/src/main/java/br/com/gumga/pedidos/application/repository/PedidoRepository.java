package br.com.gumga.pedidos.application.repository;

import io.gumga.domain.repository.GumgaCrudRepository;
import br.com.gumga.pedidos.domain.model.Pedido;

public interface PedidoRepository extends GumgaCrudRepository<Pedido, Long> {}