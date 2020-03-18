package com.enterprise.fizbuzz.processor;

import java.util.Optional;

/**
 * NumberProcessor takes a number as input and if appropriate for the processor it will return a result, otherwise
 * it will return Optional.empty
 */
public interface NumberProcessor {
    Optional<String> processNumber(Integer number);
}
