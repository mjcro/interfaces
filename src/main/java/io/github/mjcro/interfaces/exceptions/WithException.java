package io.github.mjcro.interfaces.exceptions;

/**
 * Mixin interface for objects that carry an associated exception.
 */
public interface WithException {
    /**
     * @return Exception.
     */
    Throwable getException();
}
