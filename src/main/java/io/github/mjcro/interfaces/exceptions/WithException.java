package io.github.mjcro.interfaces.exceptions;

import org.jspecify.annotations.NonNull;


/**
 * Mixin interface for objects that carry an associated exception.
 */
public interface WithException {
    /**
     * Returns the associated exception.
     *
     * @return Associated exception.
     */
    @NonNull Throwable getException();
}
