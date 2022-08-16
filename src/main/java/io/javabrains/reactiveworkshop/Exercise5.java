package io.javabrains.reactiveworkshop;

import java.io.IOException;

import org.reactivestreams.Subscription;

import reactor.core.publisher.BaseSubscriber;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberFlux() and ReactiveSources.userFlux()

        // Subscribe to a flux using the error and completion hooks
//    	ReactiveSources.intNumbersFluxWithException().subscribe( item -> System.out.println(item)
//    			, e -> System.out.println(e)
//    			, () -> System.out.println("ended"));

        // Subscribe to a flux using an implementation of BaseSubscriber
    	ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());
    
        System.out.println("Press a key to end");
        System.in.read();
    }

}


class MySubscriber<T> extends BaseSubscriber<T> {
	
	@Override
	protected void hookOnSubscribe(Subscription subscription) {
		System.out.println("Subscription started.");
		request(1);
	}
	
	@Override
	protected void hookOnNext(T value) {
		System.out.println(value.toString());
		request(1);
	}
	
	
}