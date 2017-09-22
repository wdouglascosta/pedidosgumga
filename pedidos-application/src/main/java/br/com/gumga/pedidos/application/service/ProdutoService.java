package br.com.gumga.pedidos.application.service;

import io.gumga.application.GumgaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import org.hibernate.Hibernate;

import br.com.gumga.pedidos.application.repository.ProdutoRepository;
import br.com.gumga.pedidos.domain.model.Produto;


@Service
@Transactional
public class ProdutoService extends GumgaService<Produto, Long> {

    private final static Logger LOG = LoggerFactory.getLogger(ProdutoService.class);
    private final ProdutoRepository repository;

    @Autowired
    public ProdutoService(ProdutoRepository repository) {
        super(repository);
        this.repository = repository;
    }

}