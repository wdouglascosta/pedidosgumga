/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gumga.pedidos.seed;

import br.com.gumga.pedidos.application.service.ClienteService;
import br.com.gumga.pedidos.application.service.GrupoClientesService;
import br.com.gumga.pedidos.domain.model.Cliente;
import br.com.gumga.pedidos.domain.model.GrupoClientes;
import io.gumga.core.QueryObject;
import io.gumga.domain.domains.GumgaOi;
import io.gumga.domain.seed.AppSeed;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
public class ClienteSeed implements AppSeed {
    
    private final static Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    
    @Autowired
    public ClienteService clienteService;
    
    @Autowired
    public GrupoClientesService clientesService;
    
    @Transactional
    @Override
    public void loadSeed() throws IOException {
        
        if (clienteService.hasData()) {
            LOG.info("Data found, skip " + LOG.getName());
            return;
        }
        
        QueryObject queryObject = new QueryObject();
        List<GrupoClientes> grupoClientes = clientesService.pesquisa(queryObject).getValues();
        List<List> subLists = VicAutoSeed.subLists(1, 2, grupoClientes);
        Cliente example=new Cliente();
        example.setGrupoClientes(Collections.EMPTY_LIST);
        List<Cliente> clientes=VicAutoSeed.getInteligentInstances(example, 20);
        
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            cliente.setGrupoClientes(subLists.get(i % subLists.size()));
            clienteService.save(cliente);
        }
        
    }
    
}
