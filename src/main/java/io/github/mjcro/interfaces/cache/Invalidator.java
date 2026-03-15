package io.github.mjcro.interfaces.cache;

/**
 * Mixin interface for cache-like structures that support entry invalidation by key.
 *
 * @param <T> Key type.
 */
public interface Invalidator<T> {
    /**
     * Removes entry from the cache.
     *
     * @param key Key
     */
    void invalidate(T key);
}
