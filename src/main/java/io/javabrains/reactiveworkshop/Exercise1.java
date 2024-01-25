package io.javabrains.reactiveworkshop;

import static io.javabrains.reactiveworkshop.StreamSources.*;

public class Exercise1 {

  public static void main(String[] args) {

    // Use StreamSources.intNumbersStream() and StreamSources.userStream()
    // Print all numbers in the intNumbersStream stream
    // TODO: Write code here
    intNumbersStream().forEach(System.out::println);
    System.out.println("------------------------------------");

    // Print numbers from intNumbersStream that are less than 5
    // TODO: Write code here
    intNumbersStream().filter(it -> it < 5).forEach(System.out::println);
    System.out.println("------------------------------------");

    // Print the second and third numbers in intNumbersStream that's greater than 5
    // TODO: Write code here
    intNumbersStream().filter(it -> it > 5)
        .skip(1)
        .limit(2)
        .forEach(System.out::println);
    System.out.println("------------------------------------");

    //  Print the first number in intNumbersStream that's greater than 5.
    //  If nothing is found, print -1
    // TODO: Write code here
    Integer result = intNumbersStream().filter(it -> it > 5)
        .findFirst()
        .orElse(-1);
    System.out.println("result: " + result + "\n------------------------------------");


    // Print first names of all users in userStream
    // TODO: Write code here
    userStream()
        .map(it -> it.getFirstName())
        .forEach(System.out::println);
    System.out.println("------------------------------------");

    // Print first names in userStream for users that have IDs from number stream
    // TODO: Write code here
    intNumbersStream()
        .flatMap(id -> userStream().filter(user -> user.getId() == id))
        .map(it -> it.getFirstName())
        .forEach(System.out::println);

    System.out.println("--");

    userStream()
        .filter(user -> intNumbersStream().anyMatch(i -> i == user.getId()))
        .map(it -> it.getFirstName())
        .forEach(System.out::println);
  }

}
