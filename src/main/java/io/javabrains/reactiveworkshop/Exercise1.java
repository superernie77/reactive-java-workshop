package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
    	StreamSources.intNumbersStream().forEach( i -> System.out.println(i));

    	System.out.println("-------------------------");
    	
        // Print numbers from intNumbersStream that are less than 5
    	StreamSources.intNumbersStream().filter( i -> i<5  ).forEach( i -> System.out.println(i));

    	System.out.println("-------------------------");
    	
        // Print the second and third numbers in intNumbersStream that's greater than 5
    	StreamSources.intNumbersStream().filter( i -> i > 5  ).skip(1).limit(2).forEach( i -> System.out.println(i));

    	System.out.println("-------------------------");
    	
        //  Print the first number in intNumbersStream that's greater than 5.
    	System.out.println( StreamSources.intNumbersStream().filter( i -> i > 5  ).findFirst().orElse(-1));

    	System.out.println("-------------------------");
    	
        // Print first names of all users in userStream
    	StreamSources.userStream().map( u -> u.getFirstName()).forEach( n -> System.out.println(n));

    	System.out.println("-------------------------");
    	
        // Print first names in userStream for users that have IDs from number stream
    	StreamSources.userStream().filter( u ->  StreamSources.intNumbersStream().anyMatch( i -> u.getId() == i ) ).forEach( u -> System.out.println(u.getFirstName()));

    }

}
