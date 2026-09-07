package io.github.mjcro.interfaces.database;

import org.jspecify.annotations.NonNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.function.Function;

/**
 * Function that accepts a non-null JDBC {@link Connection}, returns a non-null
 * result, and may throw an {@link SQLException}.
 *
 * @param <C> Connection type accepted by this function. Must not be null.
 * @param <R> Result type returned by this function. Must not be null.
 */
@FunctionalInterface
public interface ConnectionFunction<C extends Connection, R> {
    /**
     * Adapts a standard function to a connection function.
     *
     * @param function Non-null function to adapt.
     * @param <C>      Non-null connection type accepted by the function.
     * @param <R>      Non-null result type returned by the function.
     * @return Non-null connection function backed by the given function.
     * @throws NullPointerException If {@code function} is null.
     */
    static <C extends Connection, R> @NonNull ConnectionFunction<@NonNull C, @NonNull R> ofFunction(@NonNull Function<? super @NonNull C, ? extends @NonNull R> function) {
        Objects.requireNonNull(function, "function");
        return function::apply;
    }

    /**
     * Applies this function to a non-null connection.
     *
     * @param c Non-null database connection.
     * @return Non-null result of the function.
     * @throws SQLException If a database error occurs.
     */
    @NonNull R apply(@NonNull C c) throws SQLException;
}
