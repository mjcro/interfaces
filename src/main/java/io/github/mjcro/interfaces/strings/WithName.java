package io.github.mjcro.interfaces.strings;

import org.jspecify.annotations.NonNull;


/**
 * Mixin interface for entities that carry a {@link String} name.
 */
public interface WithName {
    /**
     * @return Entity name.
     */
    @NonNull String getName();

    /**
     * Checks if entity name equals to given one.
     *
     * @param given Name to compare to.
     * @return True if names are equal.
     */
    default boolean hasName(@NonNull String given) {
        return getName().equals(given);
    }
}
