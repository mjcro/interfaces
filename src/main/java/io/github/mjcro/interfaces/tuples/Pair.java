package io.github.mjcro.interfaces.tuples;

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
    default F getFirst() {
        return (F) get(0);
    }

    /**
     * @return Second element of tuple.
     */
    default S getSecond() {
        return (S) get(1);
    }
}
