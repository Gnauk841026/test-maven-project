package com.example;

/**
 * This is a class.
 */
public class Person {

  /**
   * This is a constructor.
   */
  public Person() {

  }
  
/**
 * @param someone the name of a person
 * @return greeting string
 */
  public final String person(final String someone) {
    return String.format("Hello, %s!", someone);
  }
}
