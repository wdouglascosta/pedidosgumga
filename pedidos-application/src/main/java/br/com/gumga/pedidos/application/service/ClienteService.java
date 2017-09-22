package br.com.gumga.pedidos.application.service;

import io.gumga.application.GumgaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import org.hibernate.Hibernate;

import br.com.gumga.pedidos.application.repository.ClienteRepository;
import br.com.gumga.pedidos.domain.model.Cliente;

import br.com.gumga.pedidos.domain.model.GrupoClientes;

@Service
@Transactional
public class ClienteService extends GumgaService<Cliente, Long> {

    private final static Logger LOG = LoggerFactory.getLogger(ClienteService.class);
    private final ClienteRepository repository;

    @Autowired
    public ClienteService(ClienteRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Transactional
    public Cliente loadClienteFat(Long id) {
    Cliente obj = view(id);

        Hibernate.initialize(obj.getGrupoClientes());


    return obj;
    }
}