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
        //        QueryObject queryObject = new QueryObject();
//        queryObject.setAq("obj.name = 'Matematica'");
//        Materia matematica = materiaService.pesquisa(queryObject).getValues().get(0);

//        Aluno aluno = new Aluno();
//        aluno.setMaterias(Arrays.asList(matematica));

        QueryObject queryObject = new QueryObject();
        queryObject.setAq("obj.privilegio= 'Platinum'");
        GrupoClientes grupoClientes = clientesService.pesquisa(queryObject).getValues().get(0);  
        
        Cliente cliente = new Cliente("Maringa", Arrays.asList(grupoClientes), GumgaOi.MARK_PUBLIC);
        clienteService.save(cliente);
        
    }
    
    
    
}
