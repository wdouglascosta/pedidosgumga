package br.com.gumga.pedidos.application.repository;

import io.gumga.domain.repository.GumgaCrudRepository;
import br.com.gumga.pedidos.domain.model.Cliente;

public interface ClienteRepository extends GumgaCrudRepository<Cliente, Long> {
}