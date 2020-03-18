package com.enterprise.fizbuzz.runner;


import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzRunnerTest {

    @Test
    void check_generated_result_gets_consumed() {
        FizzBuzzRunner underTest = new FizzBuzzRunner(number -> "foo");

        List<String> results = new ArrayList<>();
        underTest.runFizzBuzz(IntStream.of(1), results::add);

        assertThat(results).isEqualTo(
            ImmutableList.of("foo")
        );
    }

    @Test
    void check_the_are_100_consumed_results_for_100_input_ints() {
        List<String> results = new ArrayList<>();

        FizzBuzzRunner underTest = new FizzBuzzRunner(number -> "foo");
        underTest.runFizzBuzz(IntStream.rangeClosed(1, 100), results::add);

        assertThat(results).hasSize(100);
    }
}