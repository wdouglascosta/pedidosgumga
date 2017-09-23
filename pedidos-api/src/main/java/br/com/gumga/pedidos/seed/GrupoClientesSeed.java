/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gumga.pedidos.seed;

import br.com.gumga.pedidos.application.service.ClienteService;
import br.com.gumga.pedidos.application.service.GrupoClientesService;
import br.com.gumga.pedidos.domain.model.GrupoClientes;
import io.gumga.domain.domains.GumgaOi;
import io.gumga.domain.seed.AppSeed;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Gumga
 */
@Component
public class GrupoClientesSeed implements AppSeed {
    private final static Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    public GrupoClientesService service;

    @Transactional
    @Override
    public void loadSeed() throws IOException {

        if (service.hasData()) {
            LOG.info("Data found, skip "+LOG.getName());
            return;
        }
        
        service.save(new GrupoClientes("Clientes TI", "TI"));
        service.save(new GrupoClientes("Clientes ELETRO", "ELETRO"));
        service.save(new GrupoClientes("Clientes AUTO", "AUTO"));

    }

}
