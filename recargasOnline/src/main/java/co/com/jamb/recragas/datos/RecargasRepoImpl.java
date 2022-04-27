package co.com.jamb.recragas.datos;

import co.com.jamb.recragas.domain.Recargas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class RecargasRepoImpl implements RecargasRepo {

    @Autowired
    private RecargasDAO recargaDAO;



    @Override
    public Mono<Recargas> save(Recargas recarga) {
        return recargaDAO.save(recarga);
    }

    @Override
    public Mono<Void> delete(Recargas recarga) {
        return recargaDAO.delete(recarga);
    }

    @Override
    public Flux<Recargas> findByOperador(String idOperador) {
        return recargaDAO.findByOperador(idOperador);
    }


}
