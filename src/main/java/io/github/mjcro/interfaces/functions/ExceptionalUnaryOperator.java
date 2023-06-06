package io.github.mjcro.interfaces.functions;

import java.util.Objects;
import java.util.function.UnaryOperator;

/**
 * Defines behavior like {@link UnaryOperator} but able to throw checked exception.
 */
@FunctionalInterface
public interface ExceptionalUnaryOperator<T> extends ExceptionalFunction<T, T> {
    static <T> ExceptionalUnaryOperator<T> fromUnaryOperator(UnaryOperator<T> unaryOperator) {
        Objects.requireNonNull(unaryOperator, "unaryOperator");
        return unaryOperator::apply;
    }

    static <T> ExceptionalUnaryOperator<T> identity() {
        return (t) -> t;
    }
}
