/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.enterprise.fizbuzz;

import com.enterprise.fizbuzz.runner.FizzBuzzRunnerFactory;

import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * Application entry point
 */
public class App {
    public static void main(String[] args) {
        FizzBuzzType type = FizzBuzzType.Stage2;
        Consumer<String> resultConsumer = System.out::println;
        IntStream numbers = IntStream.rangeClosed(1, 100);

        FizzBuzzRunnerFactory
            .create(type)
            .runFizzBuzz(numbers, resultConsumer);
    }
}