package al3000.selectedbeans;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class Handler {

    public Mono<ServerResponse> handle(ServerRequest serverRequest) {
        String role = serverRequest.queryParam("role").get();
        System.out.printf("*** ROLE=%s\n", role);
        return Mono.empty();
    }
}
