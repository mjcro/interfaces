package io.github.mjcro.interfaces.cache;

import org.jspecify.annotations.NonNull;


/**
 * Mixin interface for cache-like structures that support entry removal by key.
 *
 * <p>Implement this interface to allow callers to explicitly evict a specific entry
 * from a cache or cache-like store without clearing the entire structure.
 *
 * @param <T> Key type. Must not be null.
 */
public interface Invalidator<T> {
    /**
     * Removes the entry associated with the given key from the cache.
     *
     * <p>If no entry exists for the key, this method does nothing.
     *
     * @param key Cache key identifying the entry to remove. Must not be null.
     */
    void invalidate(@NonNull T key);
}
