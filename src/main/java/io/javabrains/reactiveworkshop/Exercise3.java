package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;
import java.util.List;

public class Exercise3 {

  public static void main(String[] args) throws IOException {

    // Use ReactiveSources.intNumbersFlux()
    // Get all numbers in the ReactiveSources.intNumbersFlux stream
    // into a List and print the list and its size
    // TODO: Write code here
    Flux<Integer> integerFlux = ReactiveSources.intNumbersFlux();

    List<Integer> list = integerFlux.toStream().toList();

    System.out.println("List is: " + list);
    System.out.println("Size is: " + list.size());


    System.out.println("Press a key to end");
    System.in.read();
  }

}
