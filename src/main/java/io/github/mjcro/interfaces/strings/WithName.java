package io.github.mjcro.interfaces.strings;

import org.jspecify.annotations.NonNull;


/**
 * Mixin interface for entities that carry a {@link String} name.
 */
public interface WithName {
    /**
     * Returns the entity name.
     *
     * @return Entity name.
     */
    @NonNull String getName();

    /**
     * Checks whether the entity name equals the given name.
     *
     * @param given Name to compare to.
     * @return True if the names are equal.
     */
    default boolean hasName(@NonNull String given) {
        return getName().equals(given);
    }
}
