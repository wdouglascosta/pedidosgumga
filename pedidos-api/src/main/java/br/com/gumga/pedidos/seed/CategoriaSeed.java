package br.com.gumga.pedidos.seed;

import br.com.gumga.pedidos.application.service.CategoriaService;
import br.com.gumga.pedidos.domain.model.Categoria;
import io.gumga.domain.domains.GumgaOi;
import io.gumga.domain.seed.AppSeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;

@Component
public class CategoriaSeed implements AppSeed {

    @Autowired
    private CategoriaService service;

    @Override
    public void loadSeed() throws IOException {

        if (service.exists()) {
            return;
        }

        service.save(new Categoria("Alimentícios"));
        service.save(new Categoria("Higiene"));
        service.save(new Categoria("Limpeza"));

    }
}
