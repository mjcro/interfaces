package io.github.mjcro.interfaces.exceptions;

import java.util.Optional;

public interface WithOptionalException {
    /**
     * @return Exception, optional.
     */
    Optional<Throwable> getException();

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
