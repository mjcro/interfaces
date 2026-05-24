package io.github.mjcro.interfaces.functions;

import org.jspecify.annotations.NonNull;

import java.util.Objects;

/**
 * Extension of {@link java.util.function.BiConsumer} design but with three arguments.
 *
 * @param <A> First argument type.
 * @param <B> Second argument type.
 * @param <C> Third argument type.
 */
@FunctionalInterface
public interface TriConsumer<A, B, C> {
    /**
     * Performs this operation on the given arguments.
     *
     * @param a First argument.
     * @param b Second argument.
     * @param c Third argument.
     */
    void accept(@NonNull A a, @NonNull B b, @NonNull C c);

    /**
     * Returns a composed consumer that performs, in sequence, this operation followed by {@code after}.
     *
     * @param after Consumer to invoke after this consumer.
     * @return Composed consumer.
     */
    default @NonNull TriConsumer<@NonNull A, @NonNull B, @NonNull C> andThen(@NonNull TriConsumer<? super @NonNull A, ? super @NonNull B, ? super @NonNull C> after) {
        Objects.requireNonNull(after, "after");
        return (a, b, c) -> {
            this.accept(a, b, c);
            after.accept(a, b, c);
        };
    }
}
