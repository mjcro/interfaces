package io.github.mjcro.interfaces.concurrency;

import org.jspecify.annotations.Nullable;

import java.util.function.Supplier;

/**
 * Executes tasks under an exclusive distributed lock identified by a key.
 *
 * @param <T> Type of the lock key.
 */
public interface DistributedLockExecutor<T> {
    /**
     * Executes given runnable only when exclusive
     * distributed lock is obtained.
     *
     * @param lockingKey Lock key to obtain.
     * @param runnable   Runnable to run when lock is obtained.
     */
    default void executeLocked(T lockingKey, Runnable runnable) {
        executeLocked(lockingKey, () -> {
            runnable.run();
            return null;
        });
    }

    /**
     * Executes given supplier only when exclusive
     * distributed lock is obtained.
     *
     * @param lockingKey Lock key to obtain.
     * @param supplier   Supplier to run when lock is obtained.
     * @param <R>        Response type.
     * @return Supplier response.
     */
    <R> @Nullable R executeLocked(T lockingKey, Supplier<R> supplier);
}
