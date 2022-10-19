package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise9 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Print size of intNumbersFlux after the last item returns
    	//ReactiveSources.intNumbersFlux().count().subscribe( i -> System.out.println(i));

        // Collect all items of intNumbersFlux into a single list and print it
    	//ReactiveSources.intNumbersFlux().collectList().subscribe( i -> System.out.println(i));

        // Transform to a sequence of sums of adjacent two numbers
    	ReactiveSources.intNumbersFlux().buffer(2).map( l -> l.get(0)+ l.get(1)).subscribe(s -> System.out.println(s));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
