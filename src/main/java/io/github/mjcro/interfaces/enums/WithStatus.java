package io.github.mjcro.interfaces.enums;

import java.util.Collection;
import java.util.Objects;

public interface WithStatus<T extends Enum<T>> {
    /**
     * @return Entity status.
     */
    T getStatus();

    /**
     * Checks if entity status is equal to given one.
     *
     * @param given State to compare with.
     * @return True is statuses are equal.
     */
    default boolean hasStatus(T given) {
        return Objects.equals(getStatus(), given);
    }

    /**
     * Checks if entity status is equal to given one.
     *
     * @param given State container to compare with.
     * @return True is statuses are equal.
     */
    default boolean hasStatus(WithStatus<T> given) {
        return given != null && given.hasStatus(getStatus());
    }

    /**
     * Checks if entity's status contains in given statuses collection.
     *
     * @param collection Collection of statuses to match against.
     * @return True if entity's status contains in given collection.
     */
    default boolean hasStatusOneOf(Collection<T> collection) {
        return collection != null && collection.contains(getStatus());
    }
}
