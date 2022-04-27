package co.com.jamb.recragas.servicio;

import co.com.jamb.recragas.domain.Recargas;
import co.com.jamb.recragas.domain.Terceros;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RecargasService {
     public Flux<Recargas> findByOperador(String idOperador);
     public Mono<Terceros> save();


}
