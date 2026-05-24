package io.github.mjcro.interfaces.tuples;

import io.github.mjcro.interfaces.ints.WithSize;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

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
     * @return Tuple element, may be null.
     * @throws ArrayIndexOutOfBoundsException If incorrect index given.
     */
    @Nullable Object get(int i);

    /**
     * Compares this tuple to given one.
     *
     * @param that Tuple to compare data with.
     * @return Comparison result.
     * @throws ClassCastException If tuple elements are not {@link Comparable}.
     */
    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    default int compareTo(@NonNull Tuple that) {
        int thisSize = this.size();
        int thatSize = that.size();

        for (int i = 0; i < thisSize && i < thatSize; i++) {
            Object thisValue = this.get(i);
            Object thatValue = that.get(i);
            if (thisValue == thatValue) {
                continue;
            }
            if (thisValue == null) {
                return -1;
            }
            if (thatValue == null) {
                return 1;
            }
            Comparable thisElement = (Comparable) thisValue;
            Comparable thatElement = (Comparable) thatValue;
            int cmp = thisElement.compareTo(thatElement);
            if (cmp != 0) {
                return cmp;
            }
        }

        return Integer.compare(thisSize, thatSize);
    }
}
