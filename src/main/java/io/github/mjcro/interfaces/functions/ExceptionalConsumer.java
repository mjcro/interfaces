package io.github.mjcro.interfaces.functions;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * Defines behavior like {@link Consumer} but able to throw checked exception.
 */
@FunctionalInterface
public interface ExceptionalConsumer<T> {
    static <T> ExceptionalConsumer<T> fromConsumer(Consumer<T> consumer) {
        Objects.requireNonNull(consumer, "consumer");
        return consumer::accept;
    }

    void accept(T in) throws Exception;

    default ExceptionalConsumer<T> andThen(ExceptionalConsumer<? super T> after) {
        Objects.requireNonNull(after, "after");
        return (t) -> {
            this.accept(t);
            after.accept(t);
        };
    }

    default ExceptionalConsumer<T> andThen(Consumer<? super T> after) {
        Objects.requireNonNull(after, "after");
        return (t) -> {
            this.accept(t);
            after.accept(t);
        };
    }
}
