package io.github.mjcro.interfaces.strings;

import java.util.NoSuchElementException;
import java.util.Optional;

public interface WithOptionalName {
    /**
     * @return Entity name.
     */
    Optional<String> getName();

    /**
     * @return True if entity has name set.
     */
    default boolean hasName() {
        return getName().isPresent();
    }

    /**
     * Checks if entity name equals to given one.
     *
     * @param given Name to compare to.
     * @return True if names are equal.
     */
    default boolean hasName(String given) {
        Optional<String> name = getName();
        return name.isPresent() && name.get().equals(given);
    }

    /**
     * @return Entity name.
     * @throws NoSuchElementException If no id present.
     */
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    default String mustGetName() {
        return getName().get();
    }
}
