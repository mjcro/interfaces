package io.github.mjcro.interfaces.cache;

import java.time.Duration;

/**
 * Factory for creating named cache instances with configurable capacity and TTL,
 * and optionally invalidating entries across named caches.
 */
public interface NamedCacheFactory {
    /**
     * Builds and returns new cache instance.
     *
     * @param name     Cache name
     * @param capacity Max cache capacity
     * @param ttl      TTL for cache entries
     * @return New cache instance
     */
    <K, V> Cache<K, V> get(String name, int capacity, Duration ttl);

    /**
     * Invalidates cache, if factory supports it
     *
     * @param name Cache name in factory
     * @param key  Cache key
     */
    <K> void invalidate(String name, K key);
}
