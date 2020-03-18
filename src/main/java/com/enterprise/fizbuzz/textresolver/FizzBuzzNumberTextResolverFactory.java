package com.enterprise.fizbuzz.textresolver;

import com.enterprise.fizbuzz.processor.NumberProcessor;
import com.enterprise.fizbuzz.processor.PassThroughProcessor;
import com.enterprise.fizbuzz.processor.PredicateProcessor;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.function.Predicate;

/**
 * @PATTERN - Factory
 */
public class FizzBuzzNumberTextResolverFactory {

    public static NumberTextResolver create(Predicate<Integer> fizzPredicate, Predicate<Integer> buzzPredicate) {
        Predicate<Integer> fizzBuzzPredicate = fizzPredicate.and(buzzPredicate);

        List<NumberProcessor> processors = ImmutableList.of(
            new PredicateProcessor(fizzBuzzPredicate, "FizzBuzz"),
            new PredicateProcessor(fizzPredicate, "Fizz"),
            new PredicateProcessor(buzzPredicate, "Buzz"),
            new PassThroughProcessor()
        );

        return new ChainingNumberTextResolver(processors);
    }

}
