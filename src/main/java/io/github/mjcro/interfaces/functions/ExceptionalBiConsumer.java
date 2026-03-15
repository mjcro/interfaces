package io.github.mjcro.interfaces.functions;

import java.util.Objects;
import java.util.function.BiConsumer;

/**
 * Defines behavior like {@link BiConsumer} but able to throw checked exception.
 *
 * @param <T> First input type.
 * @param <U> Second input type.
 */
@FunctionalInterface
public interface ExceptionalBiConsumer<T, U> {
    /**
     * Wraps a standard {@link BiConsumer} as an {@link ExceptionalBiConsumer}.
     *
     * @param biConsumer BiConsumer to wrap.
     * @param <T>        First input type.
     * @param <U>        Second input type.
     * @return Wrapped bi-consumer.
     */
    static <T, U> ExceptionalBiConsumer<T, U> fromBiConsumer(BiConsumer<T, U> biConsumer) {
        Objects.requireNonNull(biConsumer, "biConsumer");
        return biConsumer::accept;
    }

    /**
     * Performs this operation on the given arguments.
     *
     * @param t First input argument.
     * @param u Second input argument.
     * @throws Exception If an error occurs during execution.
     */
    void accept(T t, U u) throws Exception;

    /**
     * Returns a composed consumer that performs, in sequence, this operation followed by {@code after}.
     *
     * @param after Consumer to invoke after this consumer.
     * @return Composed consumer.
     */
    default ExceptionalBiConsumer<T, U> andThen(ExceptionalBiConsumer<? super T, ? super U> after) {
        Objects.requireNonNull(after, "after");
        return (l, r) -> {
            this.accept(l, r);
            after.accept(l, r);
        };
    }

    /**
     * Returns a composed consumer that performs, in sequence, this operation followed by the standard {@code after} consumer.
     *
     * @param after Standard consumer to invoke after this consumer.
     * @return Composed consumer.
     */
    default ExceptionalBiConsumer<T, U> andThen(BiConsumer<? super T, ? super U> after) {
        Objects.requireNonNull(after, "after");
        return (l, r) -> {
            this.accept(l, r);
            after.accept(l, r);
        };
    }
}
