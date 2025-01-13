package learn.spring.webflux.subscriber;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;

import java.util.logging.Level;

public class CustomSubscriberDemo {

    public static void main(String args[]) {
        Flux.just(10, 420, 329, 793, 323)
                .log("", Level.SEVERE, SignalType.ON_ERROR)
                .subscribe(new MyIntSubscriber());
    }

}
