package io.github.mjcro.interfaces.durations;

import org.jspecify.annotations.NonNull;

import java.time.Duration;

/**
 * Mixin interface for objects that track elapsed time, e.g. the duration of a request/response.
 */
public interface WithElapsed {
    /**
     * Returns the elapsed duration.
     *
     * @return Elapsed time.
     */
    @NonNull Duration getElapsed();

    /**
     * Returns the elapsed duration in seconds.
     *
     * @return Elapsed time in seconds.
     */
    default long getElapsedSeconds() {
        return getElapsed().getSeconds();
    }

    /**
     * Returns the elapsed duration in milliseconds.
     *
     * @return Elapsed time in milliseconds.
     */
    default long getElapsedMillis() {
        return getElapsed().toMillis();
    }

    /**
     * Returns the elapsed duration in nanoseconds.
     *
     * @return Elapsed time in nanoseconds.
     */
    default long getElapsedNanos() {
        return getElapsed().toNanos();
    }
}
