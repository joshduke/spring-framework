package learn.spring.webflux.mono;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class MonoTest {

    @Test
    public void testMonoWithoutError() {
        Mono<Integer> idMono = Mono.just(10001).log();

        StepVerifier.create(idMono)
                .expectNext(10001)
                .verifyComplete();

    }

    @Test
    public void testMonoWithError() {
        Mono<Integer> idMono = Mono.error(new RuntimeException("Error getting value"));

        StepVerifier.create(idMono)
                .expectError(RuntimeException.class)
                .verify();

    }

}
