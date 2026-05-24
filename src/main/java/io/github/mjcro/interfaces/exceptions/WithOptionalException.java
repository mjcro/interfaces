package io.github.mjcro.interfaces.exceptions;

import org.jspecify.annotations.NonNull;

import java.util.Optional;

/**
 * Mixin interface for objects that optionally carry an associated exception.
 */
public interface WithOptionalException {
    /**
     * @return Exception, optional.
     */
    @NonNull Optional<@NonNull Throwable> getException();

    /**
     * @return True if exception present.
     */
    default boolean hasException() {
        return getException().isPresent();
    }

    /**
     * @return True if no exception present.
     */
    default boolean hasNoException() {
        return !hasException();
    }
}
