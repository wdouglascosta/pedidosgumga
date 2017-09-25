package br.com.gumga.pedidos.seed;

import br.com.gumga.pedidos.application.service.CategoriaService;
import br.com.gumga.pedidos.application.service.ProdutoService;
import br.com.gumga.pedidos.domain.model.Categoria;
import br.com.gumga.pedidos.domain.model.Produto;
import io.gumga.core.QueryObject;
import io.gumga.core.SearchResult;
import io.gumga.domain.domains.GumgaOi;
import io.gumga.domain.seed.AppSeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class ProdutoSeed implements AppSeed {
    
    private final static Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    private ProdutoService service;

    @Autowired
    private CategoriaService categoriaService;

    @Override
    public void loadSeed() throws IOException {
        if (service.hasData()) {
            LOG.info("Data found, skip "+LOG.getName());
            return;
        }
        Produto exProduto=new Produto();
        exProduto.setCategoria(new Categoria());
        exProduto.setQuantidade(1000);
        List<Produto> inteligentInstances = VicAutoSeed.getInteligentInstances(exProduto, 100);
        List<Categoria> values = categoriaService.pesquisa(new QueryObject()).getValues();
        int i=0;
        for (Produto p:inteligentInstances){
            p.setCategoria(values.get((i++)%values.size()));
            service.save(p);
        }

    }
    
    
    
}
