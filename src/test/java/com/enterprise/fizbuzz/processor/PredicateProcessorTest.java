package com.enterprise.fizbuzz.processor;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class PredicateProcessorTest {

    @Test
    void value_is_returned_when_predicate_is_true() {
        PredicateProcessor underTest = new PredicateProcessor(num -> true, "VALUE");

        Optional<String> result = underTest.processNumber(100);

        assertThat(result).hasValue("VALUE");
    }

    @Test
    void empty_is_returned_when_predicate_is_false() {
        PredicateProcessor underTest = new PredicateProcessor(num -> false, "VALUE");

        Optional<String> result = underTest.processNumber(100);

        assertThat(result).isEmpty();
    }
}