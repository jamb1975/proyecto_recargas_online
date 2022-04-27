package co.com.jamb.recragas.servicio;

import co.com.jamb.recragas.datos.RecargasRepo;
import co.com.jamb.recragas.domain.Recargas;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@Log4j2
public class RecargasServiceImpl implements RecargasService {

    @Autowired
    private RecargasRepo recargasRepo;
    @Override
    public Flux<Recargas> findByOperador(String idOperador) {
        return recargasRepo.findByOperador(idOperador)
    }



    public Mono<Recargas> save(Recargas recarga){
        return Mono.just(recarga).subscribeOn(Schedulers.boundedElastic()).map(b-> {
            Recargas recargas =new Recargas();

            recargas.setIdOperador(recarga.getIdOperador());
            recargas.setIdPersona(recarga.getIdPersona());
            recargas.setNumeroCelular(recarga.getNumeroCelular());
            recargas.setValor(recarga.getValor());

            return recargas;
        }).flatMap(recargasRepo::save);
    }
}
