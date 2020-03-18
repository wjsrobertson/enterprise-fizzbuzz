package com.enterprise.fizbuzz.textresolver;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @PATTERN - Composite
 *
 * An instance
 */
public class ValidatingNumberTextResolver implements NumberTextResolver {

    private final NumberTextResolver numberTextResolver;

    public ValidatingNumberTextResolver(NumberTextResolver numberTextResolver) {
        this.numberTextResolver = numberTextResolver;
    }

    @Override
    public String convertToText(Integer number) {
        checkNotNull(number, "number may not be null");
        checkArgument(number > 0, "number must be positive integer");

        return numberTextResolver.convertToText(number);
    }
}
