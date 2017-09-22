package br.com.gumga.pedidos.seed;

import br.com.gumga.pedidos.application.service.ProdutoService;
import br.com.gumga.pedidos.domain.model.Categoria;
import br.com.gumga.pedidos.domain.model.Produto;
import io.gumga.domain.domains.GumgaOi;
import io.gumga.domain.seed.AppSeed;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Arrays;

public class ProdutoSeed implements AppSeed {

    @Autowired
    private ProdutoService service;

    @Override
    public void loadSeed() throws IOException {
        if (service.exists()) {
            return;
        }
        Produto produto1 = new Produto(GumgaOi.MARK_PUBLIC, "Arroz", 234, null, null);
        Produto produto2 = new Produto(GumgaOi.MARK_PUBLIC, "Sabonete", 553, null, null);
        Produto produto3 = new Produto(GumgaOi.MARK_PUBLIC, "Detergente", 887, null, null);
        service.saveAll(Arrays.asList(produto1, produto2, produto3));

    }
}
