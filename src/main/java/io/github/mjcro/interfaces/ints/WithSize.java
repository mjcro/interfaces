package io.github.mjcro.interfaces.ints;

import io.github.mjcro.interfaces.booleans.WithEmpty;

/**
 * Mixin interface for objects that have a discrete integer size or count.
 * An empty object is one whose size is zero.
 */
public interface WithSize extends WithEmpty {
    /**
     * Returns the entity size or count.
     *
     * @return Size/count.
     */
    int size();

    @Override
    default boolean isEmpty() {
        return size() == 0;
    }
}
