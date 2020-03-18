package com.enterprise.fizbuzz.processor;

import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * An implementation of {@see NumberProcessor} which returns an Optional containing the String representation of
 * the number argument
 */
public class PassThroughProcessor implements NumberProcessor {
    @Override
    public Optional<String> processNumber(Integer number) {
        checkNotNull(number, "pass through processor can't handle null input");

        return Optional.of(number.toString());
    }
}
