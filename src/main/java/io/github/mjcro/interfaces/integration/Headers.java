package io.github.mjcro.interfaces.integration;

import io.github.mjcro.interfaces.ints.WithSize;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Headers extends WithSize, Iterable<Map.Entry<String, List<String>>> {
    /**
     * Returns list of header values with given name.
     *
     * @param name Header name.
     * @return Values.
     */
    List<String> get(String name);

    /**
     * Checks if headers contains one with given name.
     *
     * @param name Header name.
     * @return True if header exists.
     */
    default boolean contains(String name) {
        return !get(name).isEmpty();
    }

    /**
     * Returns single header value with given name.
     *
     * @param name Header name.
     * @return Value, optional.
     */
    default Optional<String> getSingle(String name) {
        return get(name).stream().findAny();
    }
}
