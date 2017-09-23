package br.com.gumga.pedidos.application.repository;

import io.gumga.domain.repository.GumgaCrudRepository;
import br.com.gumga.pedidos.domain.model.Produto;

public interface ProdutoRepository extends GumgaCrudRepository<Produto, Long> {

}
