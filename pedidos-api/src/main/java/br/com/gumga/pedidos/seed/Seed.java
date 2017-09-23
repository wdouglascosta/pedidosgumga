package br.com.gumga.pedidos.seed;

import br.com.gumga.pedidos.application.service.CategoriaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.gumga.domain.GumgaModel;
import io.gumga.domain.seed.AppSeed;
import java.io.BufferedReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;
import javax.persistence.Version;
import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class Seed implements ApplicationListener<ContextRefreshedEvent> {

    private final static Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private AtomicBoolean started = new AtomicBoolean(false);

    @Autowired
    private ClienteSeed clienteSeed;

    @Autowired
    private GrupoClientesSeed grupoSeed;

    @Autowired
    private PedidoSeed pedidoSeed;

    //Alteração WDouglas
    @Autowired
    private ProdutoSeed produtoSeed;
    //Alteração WDouglas
    @Autowired
    private CategoriaSeed categoriaSeed;

    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (started.get()) {
            return;
        }

        for (AppSeed seed : seeds()) {
            try {
                LOG.info("Running " + seed.getClass().getSimpleName());
                seed.loadSeed();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        started.set(true);
    }

    private List<AppSeed> seeds() {
        List<AppSeed> list = new LinkedList<>();
        list.add(categoriaSeed);
        list.add(produtoSeed);
        list.add(grupoSeed);
        list.add(clienteSeed);
        list.add(pedidoSeed);
        return list;
    }

   
}
