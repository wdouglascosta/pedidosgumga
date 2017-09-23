package br.com.gumga.pedidos.seed;

import br.com.gumga.pedidos.application.service.CategoriaService;
import br.com.gumga.pedidos.domain.model.Categoria;
import io.gumga.domain.domains.GumgaOi;
import io.gumga.domain.seed.AppSeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class CategoriaSeed implements AppSeed {

    private final static Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    private CategoriaService service;

    @Override
    public void loadSeed() throws IOException {

        if (service.hasData()) {
            LOG.info("Data found, skip " + LOG.getName());
            return;
        }
        List<Categoria> inteligentInstances = VicAutoSeed.getInteligentInstances(new Categoria(), 10);

        for (Categoria cat : inteligentInstances) {
            service.save(cat);
        }

    }
}
