package io.github.mjcro.interfaces.function;

import java.util.Objects;
import java.util.function.BiConsumer;

/**
 * Defines behavior like {@link BiConsumer} but able to throw checked exception.
 */
@FunctionalInterface
public interface ExceptionalBiConsumer<T, U> {
    static <T, U> ExceptionalBiConsumer<T, U> fromBiConsumer(BiConsumer<T, U> biConsumer) {
        Objects.requireNonNull(biConsumer, "biConsumer");
        return biConsumer::accept;
    }

    void accept(T t, U u) throws Exception;

    default ExceptionalBiConsumer<T, U> andThen(ExceptionalBiConsumer<? super T, ? super U> after) {
        Objects.requireNonNull(after, "after");
        return (l, r) -> {
            this.accept(l, r);
            after.accept(l, r);
        };
    }

    default ExceptionalBiConsumer<T, U> andThen(BiConsumer<? super T, ? super U> after) {
        Objects.requireNonNull(after, "after");
        return (l, r) -> {
            this.accept(l, r);
            after.accept(l, r);
        };
    }
}
