package com.enterprise.fizbuzz.textresolver;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzNumberTextResolverFactoryTest {

    @Test
    void check_always_fizz_when_fizz_predicate_always_true() {
        NumberTextResolver numberTextResolver = FizzBuzzNumberTextResolverFactory.create(num -> true, num -> false);

        IntStream.rangeClosed(1, 100).forEach(
            num -> {
                String result = numberTextResolver.convertToText(num);
                assertThat(result).isEqualTo("Fizz");
            }
        );
    }

    @Test
    void check_always_buzz_when_buzz_predicate_always_true() {
        NumberTextResolver numberTextResolver = FizzBuzzNumberTextResolverFactory.create(num -> false, num -> true);

        IntStream.rangeClosed(1, 100).forEach(
            num -> {
                String result = numberTextResolver.convertToText(num);
                assertThat(result).isEqualTo("Buzz");
            }
        );
    }

    @Test
    void check_always_fizzbuzz_when_both_predicates_always_true() {
        NumberTextResolver numberTextResolver = FizzBuzzNumberTextResolverFactory.create(num -> true, num -> true);

        IntStream.rangeClosed(1, 100).forEach(
            num -> {
                String result = numberTextResolver.convertToText(num);
                assertThat(result).isEqualTo("FizzBuzz");
            }
        );
    }
}