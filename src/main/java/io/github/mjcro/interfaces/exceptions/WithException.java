package io.github.mjcro.interfaces.exceptions;

import org.jspecify.annotations.NonNull;


/**
 * Mixin interface for objects that carry an associated exception.
 */
public interface WithException {
    /**
     * @return Exception.
     */
    @NonNull Throwable getException();
}
