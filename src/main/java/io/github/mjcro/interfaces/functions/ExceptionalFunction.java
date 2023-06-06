package io.github.mjcro.interfaces.functions;

import java.util.Objects;
import java.util.function.Function;

/**
 * Defines behavior like {@link Function} but able to throw checked exception.
 */
@FunctionalInterface
public interface ExceptionalFunction<T, R> {
    static <T, R> ExceptionalFunction<T, R> ofFunction(Function<T, R> function) {
        Objects.requireNonNull(function, "function");
        return function::apply;
    }

    static <T> ExceptionalFunction<T, T> identity() {
        return (t) -> t;
    }

    R apply(T in) throws Exception;

    default <V> ExceptionalFunction<V, R> compose(ExceptionalFunction<? super V, ? extends T> before) {
        Objects.requireNonNull(before, "before");
        return (v) -> this.apply(before.apply(v));
    }

    default <V> ExceptionalFunction<T, V> andThen(ExceptionalFunction<? super R, ? extends V> after) {
        Objects.requireNonNull(after, "after");
        return (t) -> after.apply(this.apply(t));
    }

    default <V> ExceptionalFunction<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before, "before");
        return (v) -> this.apply(before.apply(v));
    }

    default <V> ExceptionalFunction<T, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after, "after");
        return (t) -> after.apply(this.apply(t));
    }
}
