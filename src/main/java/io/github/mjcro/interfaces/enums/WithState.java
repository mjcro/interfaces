package io.github.mjcro.interfaces.enums;

import org.jspecify.annotations.Nullable;

import java.util.Collection;
import java.util.Objects;

/**
 * Mixin interface for entities that carry an enum-based state.
 *
 * @param <T> Enum type representing the state.
 */
public interface WithState<T extends Enum<T>> {
    /**
     * @return Entity state.
     */
    T getState();

    /**
     * Checks if entity state is equal to given one.
     *
     * @param given State to compare with.
     * @return True is states are equal.
     */
    default boolean hasState(T given) {
        return Objects.equals(getState(), given);
    }

    /**
     * Checks if entity state is not equal to given one.
     *
     * @param given State to compare with.
     * @return True is states are not equal.
     */
    default boolean notHasState(T given) {
        return !hasState(given);
    }

    /**
     * Checks if entity state is equal to given one.
     *
     * @param given State container to compare with, may be null.
     * @return True if states are equal.
     */
    default boolean hasState(@Nullable WithState<T> given) {
        return given != null && given.hasState(getState());
    }

    /**
     * Checks if entity state is not equal to given one.
     *
     * @param given State container to compare with, may be null.
     * @return True if states are not equal.
     */
    default boolean notHasState(@Nullable WithState<T> given) {
        return !hasState(given);
    }

    /**
     * Checks if entity's state is contained in given states collection.
     *
     * @param collection Collection of states to match against, may be null.
     * @return True if entity's state is contained in the given collection.
     */
    default boolean hasStateOneOf(@Nullable Collection<T> collection) {
        return collection != null && collection.contains(getState());
    }

    /**
     * Checks if entity's state is not contained in given states collection.
     *
     * @param collection Collection of states to match against, may be null.
     * @return True if entity's state is not contained in the given collection.
     */
    default boolean notHasStateOneOf(@Nullable Collection<T> collection) {
        return !hasStateOneOf(collection);
    }
}
