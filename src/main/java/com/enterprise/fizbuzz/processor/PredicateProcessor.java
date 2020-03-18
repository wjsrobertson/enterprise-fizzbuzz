package com.enterprise.fizbuzz.processor;

import java.util.Optional;
import java.util.function.Predicate;

public class PredicateProcessor implements NumberProcessor {

    private final Predicate<Integer> predicate;
    private final String value;

    public PredicateProcessor(Predicate<Integer> predicate, String value) {
        this.predicate = predicate;
        this.value = value;
    }

    @Override
    public Optional<String> processNumber(Integer number) {
        if (predicate.test(number)) {
            return Optional.of(value);
        } else {
            return Optional.empty();
        }
    }
}
