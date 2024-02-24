package learn.spring.webflux.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ReactiveDemoService {

    public Flux<Integer> fetchIds() {
        return Flux.just(100, 200, 300, 400, 500);
    }

}
