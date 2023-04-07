package io.github.mjcro.interfaces.enums;

import java.util.Collection;
import java.util.Objects;

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
     * @param given State container to compare with.
     * @return True is states are equal.
     */
    default boolean hasState(WithState<T> given) {
        return given != null && given.hasState(getState());
    }

    /**
     * Checks if entity state is not equal to given one.
     *
     * @param given State container to compare with.
     * @return True is states are not equal.
     */
    default boolean notHasState(WithState<T> given) {
        return !hasState(given);
    }

    /**
     * Checks if entity's state contains in given states collection.
     *
     * @param collection Collection of states to match against.
     * @return True if entity's state contains in given collection.
     */
    default boolean hasStateOneOf(Collection<T> collection) {
        return collection != null && collection.contains(getState());
    }

    /**
     * Checks if entity's state not contains in given states collection.
     *
     * @param collection Collection of states to match against.
     * @return True if entity's state contains in given collection.
     */
    default boolean notHasStateOneOf(Collection<T> collection) {
        return !hasStateOneOf(collection);
    }
}
