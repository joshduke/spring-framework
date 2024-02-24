package learn.spring.webflux.controllers;

import learn.spring.webflux.service.ReactiveDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class ReactiveController {

    @Autowired
    private ReactiveDemoService reactiveDemoService;

    @GetMapping("/ids")
    public Flux<Integer> getIds() {
        return reactiveDemoService.fetchIds();
    }

    @GetMapping(value = "/idStream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Integer> getIdsAsStream() {
        return reactiveDemoService.fetchIds()
                .delayElements(Duration.ofSeconds(1))
                .log();
    }

}
