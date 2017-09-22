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
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
public class ProdutoSeed implements AppSeed {

    @Autowired
    private ProdutoService service;

    @Autowired
    private CategoriaService categoriaService;


    @Override
    public void loadSeed() throws IOException {
        if (service.exists()) {
            return;
        }
        List<Categoria> values = categoriaService.pesquisa(new QueryObject()).getValues();
        
        service.save(new Produto("Arroz", 10, BigDecimal.TEN,values.get(0)));
        service.save(new Produto("Feijão", 10, BigDecimal.TEN,values.get(0)));
        service.save(new Produto("Pão", 10, BigDecimal.TEN,values.get(0)));

    }
}
