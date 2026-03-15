package io.github.mjcro.interfaces.functions;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * Defines behavior like {@link Consumer} but able to throw checked exception.
 *
 * @param <T> Input type.
 */
@FunctionalInterface
public interface ExceptionalConsumer<T> {
    /**
     * Wraps a standard {@link Consumer} as an {@link ExceptionalConsumer}.
     *
     * @param consumer Consumer to wrap.
     * @param <T>      Input type.
     * @return Wrapped consumer.
     */
    static <T> ExceptionalConsumer<T> fromConsumer(Consumer<T> consumer) {
        Objects.requireNonNull(consumer, "consumer");
        return consumer::accept;
    }

    /**
     * Performs this operation on the given argument.
     *
     * @param in Input argument.
     * @throws Exception If an error occurs during execution.
     */
    void accept(T in) throws Exception;

    /**
     * Returns a composed consumer that performs, in sequence, this operation followed by {@code after}.
     *
     * @param after Consumer to invoke after this consumer.
     * @return Composed consumer.
     */
    default ExceptionalConsumer<T> andThen(ExceptionalConsumer<? super T> after) {
        Objects.requireNonNull(after, "after");
        return (t) -> {
            this.accept(t);
            after.accept(t);
        };
    }

    /**
     * Returns a composed consumer that performs, in sequence, this operation followed by the standard {@code after} consumer.
     *
     * @param after Standard consumer to invoke after this consumer.
     * @return Composed consumer.
     */
    default ExceptionalConsumer<T> andThen(Consumer<? super T> after) {
        Objects.requireNonNull(after, "after");
        return (t) -> {
            this.accept(t);
            after.accept(t);
        };
    }
}
