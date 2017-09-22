package br.com.gumga.pedidos.application.repository;

import io.gumga.domain.repository.GumgaCrudRepository;
import br.com.gumga.pedidos.domain.model.Categoria;

public interface CategoriaRepository extends GumgaCrudRepository<Categoria, Long> {}