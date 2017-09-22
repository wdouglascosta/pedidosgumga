package br.com.gumga.pedidos.seed;

import br.com.gumga.pedidos.application.service.CategoriaService;
import br.com.gumga.pedidos.domain.model.Categoria;
import io.gumga.domain.domains.GumgaOi;
import io.gumga.domain.seed.AppSeed;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Arrays;

public class CategoriaSeed implements AppSeed{

    @Autowired
    private CategoriaService service;

    @Override
    public void loadSeed() throws IOException {

        if (service.exists()){
            return;
        }

        Categoria cat1 = new Categoria(GumgaOi.MARK_PUBLIC, "Alimentícios");
        Categoria cat2 = new Categoria(GumgaOi.MARK_PUBLIC, "Higiene");
        Categoria cat3 = new Categoria(GumgaOi.MARK_PUBLIC, "Limpeza");

        service.saveAll(Arrays.asList(cat1, cat2, cat3));

    }
}
