package io.github.mjcro.interfaces.cache;

import org.jspecify.annotations.NonNull;

import java.time.Duration;

/**
 * Factory for obtaining named {@link Cache} instances with configurable capacity and TTL.
 *
 * <p>Named caches allow the factory to manage a registry of caches internally,
 * enabling cross-cache invalidation by name. Implementations may return the same
 * cache instance for repeated calls with the same name, or create a new one each time.
 *
 * <p>Invalidation support is optional — implementations that do not track named caches
 * may silently ignore calls to {@link #invalidate(String, Object)}.
 */
public interface NamedCacheFactory {
    /**
     * Returns a {@link Cache} instance identified by the given name, with the specified capacity and TTL.
     *
     * @param name     Logical name of the cache. Must not be null.
     * @param capacity Maximum number of entries the cache may hold. Must be positive.
     * @param ttl      Time-to-live for each cached entry after insertion. Must not be null.
     * @return Non-null {@link Cache} instance.
     */
    <K, V> @NonNull Cache<@NonNull K, @NonNull V> get(@NonNull String name, int capacity, @NonNull Duration ttl);

    /**
     * Removes a specific entry from a named cache, if the factory supports per-cache invalidation.
     *
     * <p>If the factory does not track named caches or the named cache does not contain the key,
     * this method does nothing.
     *
     * @param name Name of the target cache. Must not be null.
     * @param key  Cache key identifying the entry to remove. Must not be null.
     */
    <K> void invalidate(@NonNull String name, @NonNull K key);
}
