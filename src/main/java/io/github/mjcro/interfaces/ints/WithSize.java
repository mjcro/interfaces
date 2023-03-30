package io.github.mjcro.interfaces.ints;

import io.github.mjcro.interfaces.booleans.WithEmpty;

public interface WithSize extends WithEmpty {
    /**
     * @return Size/count.
     */
    int size();

    @Override
    default boolean isEmpty() {
        return size() == 0;
    }
}
