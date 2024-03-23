package learn.spring.webflux.subscriber;

import reactor.core.publisher.Flux;

public class CustomSubscriberDemo {

    public static void main(String args[]) {
        Flux.just(10, 420, 329, 793, 323)
                .subscribe(new MyIntSubscriber());
    }

}
