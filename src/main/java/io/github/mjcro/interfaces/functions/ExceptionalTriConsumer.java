package io.github.mjcro.interfaces.functions;

import org.jspecify.annotations.NonNull;

import java.util.Objects;

/**
 * Defines behavior like {@link TriConsumer} but able to throw checked exception.
 *
 * @param <A> First argument type.
 * @param <B> Second argument type.
 * @param <C> Third argument type.
 */
@FunctionalInterface
public interface ExceptionalTriConsumer<A, B, C> {
    /**
     * Wraps a {@link TriConsumer} as an {@link ExceptionalTriConsumer}.
     *
     * @param triConsumer TriConsumer to wrap.
     * @param <A>         First argument type.
     * @param <B>         Second argument type.
     * @param <C>         Third argument type.
     * @return Wrapped tri-consumer.
     */
    static <A, B, C> @NonNull ExceptionalTriConsumer<@NonNull A, @NonNull B, @NonNull C> fromTriConsumer(@NonNull TriConsumer<@NonNull A, @NonNull B, @NonNull C> triConsumer) {
        Objects.requireNonNull(triConsumer, "triConsumer");
        return triConsumer::accept;
    }

    /**
     * Performs this operation on the given arguments.
     *
     * @param a First argument.
     * @param b Second argument.
     * @param c Third argument.
     * @throws Exception If an error occurs during execution.
     */
    void accept(@NonNull A a, @NonNull B b, @NonNull C c) throws Exception;

    /**
     * Returns a composed consumer that performs, in sequence, this operation followed by {@code after}.
     *
     * @param after Consumer to invoke after this consumer.
     * @return Composed consumer.
     */
    default @NonNull ExceptionalTriConsumer<@NonNull A, @NonNull B, @NonNull C> andThen(@NonNull ExceptionalTriConsumer<? super @NonNull A, ? super @NonNull B, ? super @NonNull C> after) {
        Objects.requireNonNull(after, "after");
        return (a, b, c) -> {
            this.accept(a, b, c);
            after.accept(a, b, c);
        };
    }

    /**
     * Returns a composed consumer that performs, in sequence, this operation followed by the standard {@code after} consumer.
     *
     * @param after Standard consumer to invoke after this consumer.
     * @return Composed consumer.
     */
    default @NonNull ExceptionalTriConsumer<@NonNull A, @NonNull B, @NonNull C> andThen(@NonNull TriConsumer<? super @NonNull A, ? super @NonNull B, ? super @NonNull C> after) {
        Objects.requireNonNull(after, "after");
        return (a, b, c) -> {
            this.accept(a, b, c);
            after.accept(a, b, c);
        };
    }
}
