package com.enterprise.fizbuzz.processor;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PassThroughProcessorTest {

    private final PassThroughProcessor underTest = new PassThroughProcessor();

    @Test
    void int_becomes_string_value() {
        Integer input = 69;

        Optional<String> result = underTest.processNumber(input);

        assertThat(result).hasValue("69");
    }

    @Test
    void npe_thrown_when_input_is_null() {
        Integer input = null;

        NullPointerException nullPointerException = assertThrows(NullPointerException.class, () -> underTest.processNumber(input));

        assertThat(nullPointerException.getMessage()).isEqualTo("pass through processor can't handle null input");
    }
}