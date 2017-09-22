package br.com.gumga.pedidos.seed;

import io.gumga.domain.seed.AppSeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class Seed implements ApplicationListener<ContextRefreshedEvent> {

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
        if (started.get()) return;

        for (AppSeed seed : seeds()) {
            try {
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