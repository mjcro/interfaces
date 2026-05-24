package io.github.mjcro.interfaces.exceptions;

import org.jspecify.annotations.NonNull;

import java.util.Optional;

/**
 * Mixin interface for objects that optionally carry an associated exception.
 */
public interface WithOptionalException {
    /**
     * Returns the associated exception.
     *
     * @return Exception, optional.
     */
    @NonNull Optional<@NonNull Throwable> getException();

    /**
     * Checks whether an exception is present.
     *
     * @return True if an exception is present.
     */
    default boolean hasException() {
        return getException().isPresent();
    }

    /**
     * Checks whether no exception is present.
     *
     * @return True if no exception is present.
     */
    default boolean hasNoException() {
        return !hasException();
    }
}
