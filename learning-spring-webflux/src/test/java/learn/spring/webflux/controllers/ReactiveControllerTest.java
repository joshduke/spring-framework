package learn.spring.webflux.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@WebFluxTest
public class ReactiveControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    public void testIdController() {

        Flux<Integer> idResponse = webTestClient.get().uri("/ids")
                .exchange()
                .expectStatus().isOk()
                .returnResult(Integer.class)
                .getResponseBody();

        StepVerifier.create(idResponse)
                .expectSubscription()
                .expectNext(100, 200, 300, 400, 500)
                .verifyComplete();

    }

    @Test
    public void testIdAsStreamController() {

        Flux<Integer> idResponse = webTestClient.get().uri("/idStream")
                .exchange()
                .expectStatus().isOk()
                .returnResult(Integer.class)
                .getResponseBody();

        StepVerifier.create(idResponse)
                .expectSubscription()
                .expectNext(100, 200, 300, 400, 500)
                .verifyComplete();

    }

}
