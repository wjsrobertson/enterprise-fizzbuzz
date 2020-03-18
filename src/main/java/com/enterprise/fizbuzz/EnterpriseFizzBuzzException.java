package com.enterprise.fizbuzz;

/**
 * Exception thrown within the enterprise-fizbuzz app if there is no suitable existing JVM implementation
 */
public class EnterpriseFizzBuzzException extends RuntimeException {

    public EnterpriseFizzBuzzException(String message) {
        super(message);
    }
}
