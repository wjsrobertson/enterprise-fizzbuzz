package com.enterprise.fizbuzz;

/**
 * enterprise-fizbuzz supports two types of fizbuzz:
 *
 * - Standard - traditional (divisible by 3 => Fizz, divisible by 5 => Buzz, both => FizzBuzz)
 * - Stage2 - ehnanced (divisible by 3 or has 3 in it => Fizz, divisible by 5 or has 5 in it => Buzz, both => FizzBuzz)
 */
public enum FizzBuzzType {
    Standard,
    Stage2
}
