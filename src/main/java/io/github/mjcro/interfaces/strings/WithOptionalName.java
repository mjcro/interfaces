package io.github.mjcro.interfaces.strings;

import org.jspecify.annotations.NonNull;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Mixin interface for entities that optionally carry a {@link String} name.
 */
public interface WithOptionalName {
    /**
     * Returns the entity name.
     *
     * @return Entity name.
     */
    @NonNull Optional<@NonNull String> getName();

    /**
     * Checks whether a name is present.
     *
     * @return True if the entity has a name.
     */
    default boolean hasName() {
        return getName().isPresent();
    }

    /**
     * Checks whether the entity name equals the given name.
     *
     * @param given Name to compare to.
     * @return True if the names are equal.
     */
    default boolean hasName(@NonNull String given) {
        Optional<String> name = getName();
        return name.isPresent() && name.get().equals(given);
    }

    /**
     * Returns the name or fails when it is absent.
     *
     * @return Entity name.
     * @throws NoSuchElementException If no name is present.
     */
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    default @NonNull String mustGetName() {
        return getName().get();
    }
}
