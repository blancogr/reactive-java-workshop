package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.Optional;

import static io.javabrains.reactiveworkshop.ReactiveSources.intNumberMono;

public class Exercise4 {

  public static void main(String[] args) throws IOException {

    // Use ReactiveSources.intNumberMono()

    // Print the value from intNumberMono when it emits
    // TODO: Write code here
    intNumberMono().subscribe(
        System.out::println,
        err -> System.out.println(err.getMessage()),
        () -> System.out.println("Completed"));

    // Get the value from the Mono into an integer variable
    // TODO: Write code here
    Integer i = intNumberMono().block(); // looses the benefit of reactive.
    System.out.println("Block: " + i);
    Optional<Integer> i1 = intNumberMono().blockOptional();
    i1.ifPresent(it -> System.out.println("Optional: " + i1));

    System.out.println("Press a key to end");
    System.in.read();
  }

}
