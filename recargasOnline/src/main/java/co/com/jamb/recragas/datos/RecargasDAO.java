package co.com.jamb.recragas.datos;

import co.com.jamb.recragas.domain.Recargas;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RecargasDAO extends ReactiveMongoRepository<Recargas, String> {

    @Query("{id : ?0}")
    Flux<Recargas> findByOperador(String idOperador);


      

}
