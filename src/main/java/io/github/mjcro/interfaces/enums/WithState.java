package io.github.mjcro.interfaces.enums;

import org.jspecify.annotations.NonNull;
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
     * Returns the entity state.
     *
     * @return Entity state.
     */
    @NonNull T getState();

    /**
     * Checks whether the entity state equals the given state.
     *
     * @param given Value to compare with.
     * @return True if the states are equal.
     */
    default boolean hasState(@NonNull T given) {
        return Objects.equals(getState(), given);
    }

    /**
     * Checks whether the entity state differs from the given state.
     *
     * @param given Value to compare with.
     * @return True if the states are different.
     */
    default boolean notHasState(@NonNull T given) {
        return !hasState(given);
    }

    /**
     * Checks whether the entity state equals the given state.
     *
     * @param given State container to compare with, may be null.
     * @return True if the states are equal.
     */
    default boolean hasState(@Nullable WithState<@NonNull T> given) {
        return given != null && given.hasState(getState());
    }

    /**
     * Checks whether the entity state differs from the given state.
     *
     * @param given State container to compare with, may be null.
     * @return True if the states are different.
     */
    default boolean notHasState(@Nullable WithState<@NonNull T> given) {
        return !hasState(given);
    }

    /**
     * Checks whether the entity state is contained in the given state collection.
     *
     * @param collection Collection of states to match against, may be null.
     * @return True if the entity state is contained in the given collection.
     */
    default boolean hasStateOneOf(@Nullable Collection<@NonNull T> collection) {
        return collection != null && collection.contains(getState());
    }

    /**
     * Checks whether the entity state is absent from the given state collection.
     *
     * @param collection Collection of states to match against, may be null.
     * @return True if the entity state is absent from the given collection.
     */
    default boolean notHasStateOneOf(@Nullable Collection<@NonNull T> collection) {
        return !hasStateOneOf(collection);
    }
}
