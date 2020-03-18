package com.enterprise.fizbuzz.runner;

import com.enterprise.fizbuzz.textresolver.NumberTextResolver;

import java.util.function.Consumer;
import java.util.stream.IntStream;

public class FizzBuzzRunner {

    private final NumberTextResolver textResolver;

    public FizzBuzzRunner(NumberTextResolver textResolver) {
        this.textResolver = textResolver;
    }

    public void runFizzBuzz(IntStream numbers, Consumer<String> resultConsumer) {
        numbers.mapToObj(textResolver::convertToText).forEach(resultConsumer);
    }

}
