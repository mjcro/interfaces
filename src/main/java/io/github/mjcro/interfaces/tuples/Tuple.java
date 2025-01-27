package io.github.mjcro.interfaces.tuples;

import io.github.mjcro.interfaces.ints.WithSize;

/**
 * Defines tuple of objects that can have different types.
 */
public interface Tuple extends WithSize, Comparable<Tuple> {
    /**
     * @return Amount of elements within tuple.
     */
    @Override
    int size();

    /**
     * Returns i-th element from tuple.
     *
     * @param i Index of element.
     * @return Tuple element, nullable.
     * @throws ArrayIndexOutOfBoundsException If incorrect index given.
     */
    Object get(int i);

    /**
     * Compares this tuple to given one.
     *
     * @param that Tuple to compare data with.
     * @return Comparison result.
     * @throws ClassCastException If tuple elements are not {@link Comparable}.
     */
    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    default int compareTo(Tuple that) {
        int thisSize = this.size();
        int thatSize = that.size();

        for (int i = 0; i < thisSize && i < thatSize; i++) {
            Comparable thisElement = (Comparable) this.get(i);
            Comparable thatElement = (Comparable) that.get(i);
            int cmp = thisElement.compareTo(thatElement);
            if (cmp != 0) {
                return cmp;
            }
        }

        return Integer.compare(thisSize, thatSize);
    }
}
