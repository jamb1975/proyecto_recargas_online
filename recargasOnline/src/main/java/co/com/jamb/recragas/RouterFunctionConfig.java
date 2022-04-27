package co.com.jamb.recragas;

import co.com.jamb.recragas.handler.RecargasHandler;
import co.com.jamb.recragas.servicio.RecargasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterFunctionConfig {
    @Autowired
    private RecargasService recargaService;

    @Bean
    public RouterFunction<ServerResponse> routes(RecargasHandler handler){
        return route(GET("/api/recargas"),handler::listar)


                .andRoute(POST("/api/mutant"),handler::save);
    }
}
