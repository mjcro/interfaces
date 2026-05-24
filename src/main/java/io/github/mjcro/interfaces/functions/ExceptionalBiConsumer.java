package io.github.mjcro.interfaces.functions;

import org.jspecify.annotations.NonNull;

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
    static <T, U> @NonNull ExceptionalBiConsumer<@NonNull T, @NonNull U> fromBiConsumer(@NonNull BiConsumer<@NonNull T, @NonNull U> biConsumer) {
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
    void accept(@NonNull T t, @NonNull U u) throws Exception;

    /**
     * Returns a composed consumer that performs, in sequence, this operation followed by {@code after}.
     *
     * @param after Consumer to invoke after this consumer.
     * @return Composed consumer.
     */
    default @NonNull ExceptionalBiConsumer<@NonNull T, @NonNull U> andThen(@NonNull ExceptionalBiConsumer<? super @NonNull T, ? super @NonNull U> after) {
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
    default @NonNull ExceptionalBiConsumer<@NonNull T, @NonNull U> andThen(@NonNull BiConsumer<? super @NonNull T, ? super @NonNull U> after) {
        Objects.requireNonNull(after, "after");
        return (l, r) -> {
            this.accept(l, r);
            after.accept(l, r);
        };
    }
}
