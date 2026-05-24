package io.github.mjcro.interfaces.tuples;

import org.jspecify.annotations.NonNull;

import java.util.Objects;


/**
 * Defines tuple with two elements.
 *
 * @param <F> First element type.
 * @param <S> Second element type.
 */
@SuppressWarnings("unchecked")
public interface Pair<F, S> extends Tuple {
    @Override
    default int size() {
        return 2;
    }

    /**
     * @return First element of tuple.
     */
    default @NonNull F getFirst() {
        return (F) Objects.requireNonNull(get(0), "first");
    }

    /**
     * @return Second element of tuple.
     */
    default @NonNull S getSecond() {
        return (S) Objects.requireNonNull(get(1), "second");
    }
}
