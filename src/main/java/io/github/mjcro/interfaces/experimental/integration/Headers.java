package io.github.mjcro.interfaces.experimental.integration;

import io.github.mjcro.interfaces.ints.WithSize;
import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Represents HTTP/AMQP-style headers as a multi-value map of string name to list of string values.
 */
public interface Headers extends WithSize, Iterable<Map.Entry<String, List<String>>> {
    /**
     * Returns list of header values with given name.
     *
     * @param name Header name.
     * @return Values.
     */
    @NonNull List<@NonNull String> get(@NonNull String name);

    /**
     * Checks if headers contains one with given name.
     *
     * @param name Header name.
     * @return True if header exists.
     */
    default boolean contains(@NonNull String name) {
        return !get(name).isEmpty();
    }

    /**
     * Returns single header value with given name.
     *
     * @param name Header name.
     * @return Value, optional.
     */
    default @NonNull Optional<@NonNull String> getSingle(@NonNull String name) {
        return get(name).stream().findAny();
    }
}
