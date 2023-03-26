package io.github.mjcro.interfaces.enums;

import java.util.Collection;
import java.util.Objects;

public interface WithType<T extends Enum<T>> {
    /**
     * @return Entity type
     */
    T getType();

    /**
     * Checks if entity type is equal to given one.
     *
     * @param given State to compare with.
     * @return True is types are equal.
     */
    default boolean hasType(T given) {
        return Objects.equals(getType(), given);
    }

    /**
     * Checks if entity type is equal to given one.
     *
     * @param given State container to compare with.
     * @return True is types are equal.
     */
    default boolean hasType(WithType<T> given) {
        return given != null && given.hasType(getType());
    }

    /**
     * Checks if entity's types contains in given types collection.
     *
     * @param collection Collection of types to match against.
     * @return True if entity's type contains in given collection.
     */
    default boolean hasTypeOneOf(Collection<T> collection) {
        return collection != null && collection.contains(getType());
    }
}
