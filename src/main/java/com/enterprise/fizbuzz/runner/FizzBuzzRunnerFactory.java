package com.enterprise.fizbuzz.runner;

import com.enterprise.fizbuzz.FizzBuzzType;
import com.enterprise.fizbuzz.textresolver.FizzBuzzNumberTextResolverFactory;
import com.enterprise.fizbuzz.textresolver.NumberTextResolver;
import com.enterprise.fizbuzz.textresolver.ValidatingNumberTextResolver;

import java.util.function.Predicate;

/**
 * @PATTERN - Factory
 * @PATTERN - Dependency Injection
 *
 * FizzBuzzRunnerFactory creates a FizzBuzzRunner which behaves according to FizzBuzzType - either standard or the
 * enhanced version. See the documentation on {@see FizzBuzzType} for more information about the differences.
 *
 * This class serves as the application DI wiring layer
 */
public class FizzBuzzRunnerFactory {

    public static FizzBuzzRunner create(FizzBuzzType type) {
        return new FizzBuzzRunner(
            new ValidatingNumberTextResolver(
                createChainingNumberTextResolver(type)
            )
        );
    }

    private static NumberTextResolver createChainingNumberTextResolver(FizzBuzzType type) {
        switch (type) {
            case Standard: {
                Predicate<Integer> fizzPredicate = (num) -> num != null && num % 3 == 0;
                Predicate<Integer> buzzPredicate = (num) -> num != null && num % 5 == 0;

                return FizzBuzzNumberTextResolverFactory.create(fizzPredicate, buzzPredicate);
            }
            case Stage2: {
                Predicate<Integer> fizzPredicate = (num) -> num != null
                    && (num % 3 == 0 || num.toString().contains("3"));

                Predicate<Integer> buzzPredicate = (num) -> num != null
                    && (num % 5 == 0 || num.toString().contains("5"));

                return FizzBuzzNumberTextResolverFactory.create(fizzPredicate, buzzPredicate);
            }
            default: {
                throw new IllegalArgumentException("invalid text resolver type");
            }
        }
    }
}