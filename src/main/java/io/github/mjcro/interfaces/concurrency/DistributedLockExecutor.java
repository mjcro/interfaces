package io.github.mjcro.interfaces.concurrency;

import java.util.function.Supplier;

public interface DistributedLockExecutor<T> {
    /**
     * Executes given runnable only when exclusive
     * distributed lock is obtained.
     *
     * @param lockingKey Lock key to obtain.
     * @param runnable   Runnable to run when lock is obtained.
     */
    void executeLocked(T lockingKey, Runnable runnable);

    /**
     * Executes given supplier only when exclusive
     * distributed lock is obtained.
     *
     * @param lockingKey Lock key to obtain.
     * @param supplier   Supplier to run when lock is obtained.
     * @param <R>        Response type.
     * @return Supplier response.
     */
    <R> R executeLocked(T lockingKey, Supplier<R> supplier);
}
