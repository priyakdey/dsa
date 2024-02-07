package com.priyakdey.algorithms.exception;

/**
 * Util exception class to mock behaviour of <a href="https://doc.rust-lang.org/std/macro.todo.html">todo from Rust</a>
 *
 * @author Priyak Dey
 */
public class TodoException extends RuntimeException {

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public TodoException(String message) {
        super(message);
    }
}