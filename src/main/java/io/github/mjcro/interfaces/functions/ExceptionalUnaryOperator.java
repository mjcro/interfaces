package io.github.mjcro.interfaces.functions;

import org.jspecify.annotations.NonNull;

import java.util.Objects;
import java.util.function.UnaryOperator;

/**
 * Defines behavior like {@link UnaryOperator} but able to throw checked exception.
 *
 * @param <T> Input and result type.
 */
@FunctionalInterface
public interface ExceptionalUnaryOperator<T> extends ExceptionalFunction<T, T> {
    /**
     * Wraps a standard {@link UnaryOperator} as an {@link ExceptionalUnaryOperator}.
     *
     * @param unaryOperator UnaryOperator to wrap.
     * @param <T>           Input and result type.
     * @return Wrapped unary operator.
     */
    static <T> @NonNull ExceptionalUnaryOperator<@NonNull T> fromUnaryOperator(@NonNull UnaryOperator<@NonNull T> unaryOperator) {
        Objects.requireNonNull(unaryOperator, "unaryOperator");
        return unaryOperator::apply;
    }

    /**
     * Returns an identity operator that always returns its input argument.
     *
     * @param <T> Input and result type.
     * @return Identity operator.
     */
    static <T> @NonNull ExceptionalUnaryOperator<@NonNull T> identity() {
        return (t) -> t;
    }
}
