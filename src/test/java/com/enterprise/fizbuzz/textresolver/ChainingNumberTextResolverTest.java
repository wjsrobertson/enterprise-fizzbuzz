package com.enterprise.fizbuzz.textresolver;

import com.enterprise.fizbuzz.EnterpriseFizzBuzzException;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChainingNumberTextResolverTest {

    @Test
    void exception_is_thrown_when_no_processor_matches() {
        ChainingNumberTextResolver underTest = new ChainingNumberTextResolver(Collections.emptyList());

        EnterpriseFizzBuzzException thrown = assertThrows(
            EnterpriseFizzBuzzException.class,
            () -> underTest.convertToText(100)
        );

        assertThat(thrown.getMessage()).isEqualTo("no processor handled 100");
    }

    @Test
    void result_is_returned_when_processor_matches() {
        ChainingNumberTextResolver underTest = new ChainingNumberTextResolver(
            ImmutableList.of(
                number -> Optional.of("value")
            )
        );

        String value = underTest.convertToText(100);

        assertThat(value).isEqualTo("value");
    }

    @Test
    void first_result_in_list_is_returned_when_first_processor_matches() {
        ChainingNumberTextResolver underTest = new ChainingNumberTextResolver(
            ImmutableList.of(
                number -> Optional.of("first"),
                number -> Optional.of("second")
            )
        );

        String value = underTest.convertToText(100);

        assertThat(value).isEqualTo("first");
    }

    @Test
    void empty_results_are_not_returned_when_last_processor_matches() {
        ChainingNumberTextResolver underTest = new ChainingNumberTextResolver(
            ImmutableList.of(
                number -> Optional.empty(),
                number -> Optional.empty(),
                number -> Optional.of("last")
            )
        );

        String value = underTest.convertToText(100);

        assertThat(value).isEqualTo("last");
    }
}