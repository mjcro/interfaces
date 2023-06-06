package io.github.mjcro.interfaces.function;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Defines behavior like {@link BiFunction} but able to throw checked exception.
 */
@FunctionalInterface
public interface ExceptionalBiFunction<T, U, R> {
    static <T, U, R> ExceptionalBiFunction<T, U, R> ofBiFunction(BiFunction<T, U, R> biFunction) {
        Objects.requireNonNull(biFunction, "biFunction");
        return biFunction::apply;
    }

    R apply(T t, U u) throws Exception;

    default <V> ExceptionalBiFunction<T, U, V> andThen(ExceptionalFunction<? super R, ? extends V> after) {
        Objects.requireNonNull(after, "after");
        return (t, u) -> after.apply(this.apply(t, u));
    }

    default <V> ExceptionalBiFunction<T, U, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after, "after");
        return (t, u) -> after.apply(this.apply(t, u));
    }
}
