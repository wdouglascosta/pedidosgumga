package br.com.gumga.pedidos.application.repository;

import io.gumga.domain.repository.GumgaCrudRepository;
import br.com.gumga.pedidos.domain.model.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends GumgaCrudRepository<Cliente, Long> {

    @Query("SELECT o FROM Cliente o JOIN FETCH o.grupoClientes")
    List<Cliente> listaGrupos();
}


