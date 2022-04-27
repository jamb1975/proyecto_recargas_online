package co.com.jamb.recragas.datos;

import co.com.jamb.recragas.domain.Recargas;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RecargasRepo {

    public Flux<Recargas> findAll();

    public Mono<Recargas> save(Recargas recargas);


    public Mono<Void> delete(Recargas recargas);

    public Flux<Recargas> findByOperador(String idOperador);



}
