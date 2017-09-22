package br.com.gumga.pedidos.application.service;

import io.gumga.application.GumgaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import org.hibernate.Hibernate;

import br.com.gumga.pedidos.application.repository.GrupoClientesRepository;
import br.com.gumga.pedidos.domain.model.GrupoClientes;


@Service
@Transactional
public class GrupoClientesService extends GumgaService<GrupoClientes, Long> {

    private final static Logger LOG = LoggerFactory.getLogger(GrupoClientesService.class);
    private final GrupoClientesRepository repository;

    @Autowired
    public GrupoClientesService(GrupoClientesRepository repository) {
        super(repository);
        this.repository = repository;
    }

}