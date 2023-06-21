package io.github.mjcro.interfaces.functions;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

/**
 * Defines behavior like {@link Supplier} but able to throw checked exception.
 */
@FunctionalInterface
public interface ExceptionalSupplier<T> {
    static <T> ExceptionalSupplier<T> fromSupplier(Supplier<T> supplier) {
        Objects.requireNonNull(supplier, "supplier");
        return supplier::get;
    }

    static <T> ExceptionalSupplier<T> fromCallable(Callable<T> callable) {
        Objects.requireNonNull(callable, "callable");
        return callable::call;
    }

    T get() throws Exception;

    default Callable<T> toCallable() {
        return this::get;
    }
}
