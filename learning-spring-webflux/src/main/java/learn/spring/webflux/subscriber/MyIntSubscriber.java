package learn.spring.webflux.subscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MyIntSubscriber implements Subscriber<Integer> {

    private Subscription subscription;
    @Override
    public void onSubscribe(Subscription s) {
        this.subscription = s;
        this.subscription.request(5);
    }

    @Override
    public void onNext(Integer i) {
        System.out.println("Received item --> " + i);
        this.subscription.request(5);
    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {
        System.out.println("All data received");
    }
}
