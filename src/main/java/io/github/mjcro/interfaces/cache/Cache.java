package io.github.mjcro.interfaces.cache;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public interface Cache<K, V> extends Invalidator<K> {
    /**
     * Returns entry by key.
     *
     * @param key Key
     * @return Optional Value
     */
    Optional<V> get(K key);

    /**
     * Stores entry to cache.
     *
     * @param key   Key
     * @param value value
     */
    void put(K key, V value);

    /**
     * Fetches entry from cache and runs mapping function if no value present for provided key
     * Value, received by mapping function, will be stored in cache.
     *
     * @param key             Cache key
     * @param mappingFunction Function used to obtain value on cache miss
     * @return Optional value
     */
    @SuppressWarnings("unchecked")
    default Optional<V> computeIfAbsent(
            final K key,
            final Function<? super K, Optional<? extends V>> mappingFunction
    ) {
        Objects.requireNonNull(mappingFunction, "mappingFunction");

        Optional<? extends V> opt = get(key);
        if (!opt.isPresent()) {
            opt = mappingFunction.apply(key);
            opt.ifPresent(v -> put(key, v));
        }
        return (Optional<V>) opt;
    }
}
