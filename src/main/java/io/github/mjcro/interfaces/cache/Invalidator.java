package io.github.mjcro.interfaces.cache;

public interface Invalidator<T> {
    /**
     * Removes entry from the cache.
     *
     * @param key Key
     */
    void invalidate(T key);
}
