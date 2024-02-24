package learn.spring.webflux.flux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FluxTest {

    @Test
    public void testSimpleFlux() {
        Flux<String> stringFlux = Flux.just("Josh", "Joy", "Joel")
//                .concatWith(Flux.error(new RuntimeException("Error with Flux")))
                .concatWith(Flux.just("After error"))
                .log();
        stringFlux.subscribe(System.out::println,
                (error)-> System.err.print(error),
                () -> System.out.println("COMPLETED EVENT"));
    }

    @Test
    public void testFluxWithoutError() {
        Flux<Integer> integerFlux = Flux.just(10, 40, 20, 100);

        StepVerifier.create(integerFlux)
                .expectNext(10, 40, 20, 100)
                .verifyComplete();
    }

    @Test
    public void testFluxWithError() {
        Flux<Integer> integerFlux = Flux.just(10, 40, 20, 100)
                .concatWith(Flux.error(new RuntimeException("Error in value")));

        StepVerifier.create(integerFlux)
                .expectNext(10, 40, 20, 100)
                .expectError(RuntimeException.class)
                .verify();
    }

}
