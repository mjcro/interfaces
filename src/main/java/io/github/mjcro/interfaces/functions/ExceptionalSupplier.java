package io.github.mjcro.interfaces.functions;

import java.util.Objects;
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

    T get() throws Exception;
}
