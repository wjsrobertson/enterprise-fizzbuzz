package com.enterprise.fizbuzz.textresolver;

import com.enterprise.fizbuzz.EnterpriseFizzBuzzException;
import com.enterprise.fizbuzz.processor.NumberProcessor;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Optional;

/**
 * @PATTERN - Chain of responsibility
 *
 * This class exposes a single method convertToText which iterates over a list of {@see NumberProcessor}s
 * attempting to get a non-empty result. The first non-empty result will be returned, or an
 * {@see EnterpriseFizzBuzzException} will be thrown if there was no matching processor result
 */
public class ChainingNumberTextResolver implements NumberTextResolver {

    private final List<NumberProcessor> processors;

    public ChainingNumberTextResolver(List<NumberProcessor> chain) {
        this.processors = ImmutableList.copyOf(chain);
    }

    public String convertToText(Integer number) {
        return attemptAllProcessors(number)
            .orElseThrow(() -> new EnterpriseFizzBuzzException("no processor handled " + number));
    }

    private Optional<String> attemptAllProcessors(Integer number) {
        for (NumberProcessor processor : processors) {
            Optional<String> result = processor.processNumber(number);
            if (result.isPresent()) {
                return result;
            }
        }

        return Optional.empty();
    }
}