package io.github.mjcro.interfaces.cache;

import org.jspecify.annotations.NonNull;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

/**
 * Generic key-value cache interface supporting read, write, invalidation, and compute-if-absent operations.
 *
 * <p>All keys and values are non-null. Methods return {@link Optional} to distinguish
 * a missing entry from a stored {@code null} value (which is not permitted).
 *
 * @param <K> Key type. Must not be null.
 * @param <V> Value type. Must not be null.
 */
public interface Cache<K, V> extends Invalidator<K> {
    /**
     * Returns the cached value for the given key, or an empty {@link Optional} on a cache miss.
     *
     * @param key Cache key. Must not be null.
     * @return Non-null {@link Optional} containing the cached value, or empty if not present.
     */
    @NonNull Optional<@NonNull V> get(@NonNull K key);

    /**
     * Stores a key-value pair in the cache, overwriting any previously cached value for the same key.
     *
     * @param key   Cache key. Must not be null.
     * @param value Value to cache. Must not be null.
     */
    void put(@NonNull K key, @NonNull V value);

    /**
     * Returns the cached value for the given key, invoking the mapping function to compute and store
     * a value on a cache miss.
     *
     * <p>If the mapping function returns an empty {@link Optional}, nothing is stored in the cache
     * and an empty {@link Optional} is returned to the caller.
     *
     * @param key             Cache key. Must not be null.
     * @param mappingFunction Function invoked on cache miss to compute the value. Must not be null.
     *                        Receives the cache key and returns an {@link Optional} result.
     * @return Non-null {@link Optional} containing the value (from cache or from the mapping function),
     * or empty if the mapping function produced no value.
     */
    @SuppressWarnings("unchecked")
    default @NonNull Optional<@NonNull V> computeIfAbsent(
            final @NonNull K key,
            final @NonNull Function<? super @NonNull K, @NonNull Optional<? extends @NonNull V>> mappingFunction
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
