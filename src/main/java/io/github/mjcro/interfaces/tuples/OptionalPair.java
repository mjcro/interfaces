package io.github.mjcro.interfaces.tuples;

import org.jspecify.annotations.NonNull;

import java.util.Optional;

/**
 * Defines tuple with two elements.
 *
 * @param <F> First element type.
 * @param <S> Second element type.
 */
@SuppressWarnings("unchecked")
public interface OptionalPair<F, S> extends Tuple {
    @Override
    default int size() {
        return 2;
    }

    /**
     * Returns the first tuple element.
     *
     * @return First element of tuple.
     */
    default @NonNull Optional<@NonNull F> getFirst() {
        return (Optional<F>) Optional.ofNullable(get(0));
    }

    /**
     * Returns the second tuple element.
     *
     * @return Second element of tuple.
     */
    default @NonNull Optional<@NonNull S> getSecond() {
        return (Optional<S>) Optional.ofNullable(get(1));
    }
}
