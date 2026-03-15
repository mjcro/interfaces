package io.github.mjcro.interfaces.durations;

import java.time.Duration;

/**
 * Mixin interface for objects that track elapsed time, e.g. the duration of a request/response.
 */
public interface WithElapsed {
    /**
     * @return Elapsed time.
     */
    Duration getElapsed();

    /**
     * @return Elapsed time in seconds.
     */
    default long getElapsedSeconds() {
        return getElapsed().getSeconds();
    }

    /**
     * @return Elapsed time in milliseconds.
     */
    default long getElapsedMillis() {
        return getElapsed().toMillis();
    }

    /**
     * @return Elapsed time in nanoseconds.
     */
    default long getElapsedNanos() {
        return getElapsed().toNanos();
    }
}
