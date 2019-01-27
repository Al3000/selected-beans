package al3000.selectedbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class Config {

    @Bean
    public RouterFunction<ServerResponse> createRoute(Handler handler) {
        return route(RequestPredicates.GET("/bla"), handler::handle);
    }
}
