package com.enterprise.fizbuzz.runner;


import com.enterprise.fizbuzz.FizzBuzzType;
import com.google.common.collect.ImmutableSet;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzRunnerFactoryTest {

    private FizzBuzzRunner standardRunner = FizzBuzzRunnerFactory.create(FizzBuzzType.Standard);

    private FizzBuzzRunner stage2Runner = FizzBuzzRunnerFactory.create(FizzBuzzType.Stage2);

    @Test
    void check_three_is_fizz_for_standard() {
        assertAllForRunner(IntStream.of(3), "Fizz", standardRunner);
    }

    @Test
    void check_five_is_buzz_for_standard() {
        assertAllForRunner(IntStream.of(5), "Buzz", standardRunner);
    }

    @Test
    void check_fifteen_is_fizzbuzz_for_standard() {
        assertAllForRunner(IntStream.of(15), "FizzBuzz", standardRunner);
    }

    @Test
    void check_values_divisible_by_3_but_not_5_are_fizz_up_to_100_for_standard() {
        IntStream ints = IntStream.rangeClosed(1, 100).filter(n -> n % 3 == 0).filter(n -> n % 5 != 0);

        assertAllForRunner(ints, "Fizz", standardRunner);
    }

    @Test
    void check_values_divisible_by_5_but_not_3_are_buzz_up_to_100_for_standard() {
        IntStream ints = IntStream.rangeClosed(1, 100).filter(n -> n % 5 == 0).filter(n -> n % 3 != 0);

        assertAllForRunner(ints, "Buzz", standardRunner);
    }

    @Test
    void check_values_divisible_by_3_and_5_are_fizzbuzz_up_to_100_for_standard() {
        IntStream ints = IntStream.rangeClosed(1, 100).filter(n -> n % 15 == 0);

        assertAllForRunner(ints, "FizzBuzz", standardRunner);
    }

    @Test
    void check_three_is_fizz_for_stage2() {
        assertAllForRunner(IntStream.of(3), "Fizz", stage2Runner);
    }

    @Test
    void check_five_is_buzz_for_stage2() {
        assertAllForRunner(IntStream.of(5), "Buzz", stage2Runner);
    }

    @Test
    void check_fifteen_is_fizzbuzz_for_stage2() {
        assertAllForRunner(IntStream.of(15), "FizzBuzz", stage2Runner);
    }

    @Test
    void check_values_divisible_by_3_but_not_5_not_containing_5_are_fizz_up_to_100_for_stage2() {
        IntStream ints = IntStream.rangeClosed(1, 100)
            .filter(n -> n % 3 == 0)
            .filter(n -> n % 5 != 0)
            .filter(n -> ! String.valueOf(n).contains("5"));

        assertAllForRunner(ints, "Fizz", stage2Runner);
    }

    @Test
    void check_values_divisible_by_5_but_not_3_not_containing_3_are_buzz_up_to_100_for_stage2() {
        IntStream ints = IntStream.rangeClosed(1, 100)
            .filter(n -> n % 5 == 0)
            .filter(n -> n % 3 != 0)
            .filter(n -> ! String.valueOf(n).contains("3"));

        assertAllForRunner(ints, "Buzz", stage2Runner);
    }

    @Test
    void check_values_divisible_by_3_and_5_are_fizzbuzz_up_to_100_for_stage2() {
        IntStream ints = IntStream.rangeClosed(1, 100).filter(n -> n % 15 == 0);

        assertAllForRunner(ints, "FizzBuzz", stage2Runner);
    }

    @Test
    void check_values_containing_3_and_5_are_fizzbuzz_up_to_100_for_stage2() {
        IntStream ints = IntStream.rangeClosed(1, 100)
            .filter(n -> {
                String string = String.valueOf(n);
                return string.contains("3") && string.contains("5");
            });

        assertAllForRunner(ints, "FizzBuzz", stage2Runner);
    }

    private void assertAllForRunner(IntStream ints, String expected, FizzBuzzRunner standardRunner) {
        Set<String> results = new HashSet<>();

        standardRunner.runFizzBuzz(ints, results::add);

        assertThat(results).isEqualTo(ImmutableSet.of(expected));
    }
}