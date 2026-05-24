package io.github.mjcro.interfaces.sql;

import org.jspecify.annotations.NonNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.function.Function;

/**
 * Function that can throw {@link SQLException}.
 */
@FunctionalInterface
public interface ConnectionFunction<C extends Connection, R> {
    /**
     * Constructs function that allows SQL exception
     * to be thrown from a standard function.
     *
     * @param function Function to wrap.
     * @return Function that can throw {@link SQLException}.
     */
    static <C extends Connection, R> @NonNull ConnectionFunction<@NonNull C, @NonNull R> ofFunction(@NonNull Function<? super @NonNull C, ? extends @NonNull R> function) {
        Objects.requireNonNull(function, "function");
        return function::apply;
    }

    /**
     * Applies this function to the given connection.
     *
     * @param c Database connection.
     * @return Result of the function.
     * @throws SQLException If a database error occurs.
     */
    @NonNull R apply(@NonNull C c) throws SQLException;
}
