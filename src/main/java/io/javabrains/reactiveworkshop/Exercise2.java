package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

import static io.javabrains.reactiveworkshop.ReactiveSources.*;

public class Exercise2 {

  public static void main(String[] args) throws IOException {
    //userFlux()
    // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

    // Print all numbers in the ReactiveSources.intNumbersFlux stream
    // TODO: Write code here
    // subscribe takes a lambda: whenever the flux emits, run that lambda
    Flux<Integer> integerFlux = intNumbersFlux();
    integerFlux.subscribe(System.out::println);
    integerFlux.subscribe(it -> System.out.println("Another one: " + it));


    // Print all users in the ReactiveSources.userFlux stream
    // TODO: Write code here
    userFlux().subscribe(System.out::println);


    //if this is not here, the process ends immediately after the subscription:
    // the method does not wait for that flux to emit anything

    System.out.println("Press a key to end");
    System.in.read();
  }

}
