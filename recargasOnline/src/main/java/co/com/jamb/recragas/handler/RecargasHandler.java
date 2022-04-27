package co.com.jamb.recragas.handler;

import co.com.jamb.recragas.datos.RecargasRepo;
import co.com.jamb.recragas.domain.Recargas;
import co.com.jamb.recragas.servicio.RecargasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class RecargasHandler {

    @Autowired
    private RecargasService recargasService;

    @Autowired
    private Validator validator;
    @Autowired
    private RecargasRepo recargasRepo;
    public Mono<ServerResponse> listar(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(recargasService.findByOperador("1"), Recargas.class);
    }



    public Mono<ServerResponse> save(ServerRequest request){

        recargasService.save();

}
