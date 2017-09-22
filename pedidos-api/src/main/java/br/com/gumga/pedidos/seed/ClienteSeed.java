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
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Gumga
 */
@Component
public class ClienteSeed implements AppSeed{
    
    @Autowired
    public ClienteService clienteService;
    
    @Autowired
    public GrupoClientesService clientesService;
    

    @Transactional
    @Override
    public void loadSeed() throws IOException {
        
        
        
        QueryObject queryObject = new QueryObject();
        List<GrupoClientes> grupoClientes = clientesService.pesquisa(queryObject).getValues();  
        
        Cliente cliente = new Cliente("Fulano","Maringa", grupoClientes);
        clienteService.save(cliente);
        
    }
    
    
    
}
