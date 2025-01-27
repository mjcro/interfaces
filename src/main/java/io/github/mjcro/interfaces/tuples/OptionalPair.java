package io.github.mjcro.interfaces.tuples;

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
     * @return First element of tuple.
     */
    default Optional<F> getFirst() {
        return (Optional<F>) Optional.ofNullable(get(0));
    }

    /**
     * @return Second element of tuple.
     */
    default Optional<S> getSecond() {
        return (Optional<S>) Optional.ofNullable(get(1));
    }
}
