package com.enterprise.fizbuzz.textresolver;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidatingNumberTextResolverTest {

    private final ValidatingNumberTextResolver underTest = new ValidatingNumberTextResolver(number -> "foo");

    @Test
    void npe_thrown_when_input_is_null() {
        Integer input = null;

        NullPointerException nullPointerException = assertThrows(NullPointerException.class, () -> underTest.convertToText(input));

        assertThat(nullPointerException.getMessage()).isEqualTo("number may not be null");
    }

    @Test
    void zero_as_input_is_invald_argument() {
        Integer input = 0;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> underTest.convertToText(input));

        assertThat(exception.getMessage()).isEqualTo("number must be positive integer");
    }

    @Test
    void negative_number_as_input_is_invald_argument() {
        Integer input = -1;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> underTest.convertToText(input));

        assertThat(exception.getMessage()).isEqualTo("number must be positive integer");
    }
}