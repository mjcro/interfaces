package io.github.mjcro.interfaces.functions;

import org.jspecify.annotations.NonNull;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

/**
 * Defines {@link Supplier}-like behavior that can throw checked exceptions.
 *
 * @param <T> Result type.
 */
@FunctionalInterface
public interface ExceptionalSupplier<T> {
    /**
     * Wraps a standard {@link Supplier} as an {@link ExceptionalSupplier}.
     *
     * @param supplier Supplier to wrap.
     * @param <T>      Result type.
     * @return Wrapped supplier.
     */
    static <T> @NonNull ExceptionalSupplier<@NonNull T> fromSupplier(@NonNull Supplier<@NonNull T> supplier) {
        Objects.requireNonNull(supplier, "supplier");
        return supplier::get;
    }

    /**
     * Wraps a {@link Callable} as an {@link ExceptionalSupplier}.
     *
     * @param callable Callable to wrap.
     * @param <T>      Result type.
     * @return Wrapped callable.
     */
    static <T> @NonNull ExceptionalSupplier<@NonNull T> fromCallable(@NonNull Callable<@NonNull T> callable) {
        Objects.requireNonNull(callable, "callable");
        return callable::call;
    }

    /**
     * Gets a result.
     *
     * @return A result.
     * @throws Exception If an error occurs during execution.
     */
    @NonNull T get() throws Exception;

    /**
     * Converts this supplier to a {@link Callable}.
     *
     * @return This supplier as a {@link Callable}.
     */
    default @NonNull Callable<@NonNull T> toCallable() {
        return this::get;
    }
}
