package br.com.gumga.pedidos.api;

import br.com.gumga.pedidos.application.service.ClienteService;
import br.com.gumga.pedidos.application.service.PedidoService;
import br.com.gumga.pedidos.domain.model.Cliente;
import br.com.gumga.pedidos.domain.model.Pedido;
import io.gumga.application.GumgaService;
import io.gumga.presentation.GumgaAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMethod;
import io.gumga.presentation.RestResponse;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.validation.BindingResult;
import io.gumga.application.GumgaTempFileService;
import io.gumga.domain.domains.GumgaImage;
import io.gumga.presentation.GumgaAPI;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/pedido")
@Transactional
public class PedidoAPI extends GumgaAPI<Pedido, Long> {

    @Autowired
    public PedidoAPI(PedidoService service) {
        super(service);
    }

    @Override
    public Pedido load(@PathVariable Long id) {
        return ((PedidoService) service).loadPedidoFat(id);
    }
}
