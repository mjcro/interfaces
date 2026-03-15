package io.github.mjcro.interfaces.builders;

import org.jspecify.annotations.NonNull;

/**
 * Generic builder.
 *
 * @param <T> Type to build.
 */
public interface Builder<T> {
    /**
     * Builds and returns the constructed object.
     *
     * @return Newly constructed object.
     */
    @NonNull T build();
}
