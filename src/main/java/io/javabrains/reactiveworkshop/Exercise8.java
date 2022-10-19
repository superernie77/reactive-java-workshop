package io.javabrains.reactiveworkshop;

import java.io.IOException;

import reactor.core.publisher.Flux;

public class Exercise8 {

	public static void main(String[] args) throws IOException {

		// Use ReactiveSources.intNumbersFluxWithException()

		// Print values from intNumbersFluxWithException and print a message when error
		// happens
		// ReactiveSources.intNumbersFluxWithException()
		// .subscribe(num -> System.out.println(num), err -> System.out.println(err));

		// Print values from intNumbersFluxWithException and continue on errors
		//ReactiveSources.intNumbersFluxWithException().onErrorContinue((e, item) -> System.out.println(e))
		//		.subscribe(i -> System.out.println(i));

		// Print values from intNumbersFluxWithException and when errors
		// happen, replace with a fallback sequence of -1 and -2
		ReactiveSources.intNumbersFluxWithException()
			.onErrorResume( err -> Flux.just(-1,-2))
			.subscribe(i -> System.out.println(i));

		System.out.println("Press a key to end");
		System.in.read();
	}

}
