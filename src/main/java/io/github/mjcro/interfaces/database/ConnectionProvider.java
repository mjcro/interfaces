package io.github.mjcro.interfaces.database;

import org.jspecify.annotations.NonNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Provides non-null JDBC {@link Connection} instances and runs connection-scoped
 * operations that automatically close each acquired connection.
 */
@FunctionalInterface
public interface ConnectionProvider {
    /**
     * Adapts a supplier of non-null connections to a connection provider.
     *
     * @param supplier Non-null connection supplier.
     * @return Non-null connection provider backed by the supplier.
     * @throws NullPointerException If {@code supplier} is null.
     */
    static @NonNull ConnectionProvider ofSupplier(final @NonNull Supplier<@NonNull Connection> supplier) {
        Objects.requireNonNull(supplier, "supplier");
        return supplier::get;
    }

    /**
     * Creates a provider that returns the same non-null connection for every request.
     * Connection-scoped invocation methods close that connection after use.
     *
     * @param connection Non-null established connection.
     * @return Non-null provider backed by the connection.
     * @throws NullPointerException If {@code connection} is null.
     */
    static @NonNull ConnectionProvider ofConnection(final @NonNull Connection connection) {
        Objects.requireNonNull(connection, "connection");
        return () -> connection;
    }

    /**
     * Acquires a non-null database connection.
     *
     * @return Non-null database connection.
     * @throws SQLException If the connection cannot be acquired.
     */
    @NonNull Connection getConnection() throws SQLException;

    /**
     * Runs a function with an acquired connection and closes the connection afterward.
     *
     * @param function Non-null function to invoke.
     * @param <T>      Non-null function result type.
     * @return Non-null function result.
     * @throws SQLException If connection acquisition, function execution, or connection closing fails.
     */
    default <T> @NonNull T invokeWithConnection(@NonNull ConnectionFunction<@NonNull Connection, @NonNull T> function) throws SQLException {
        try (Connection connection = getConnection()) {
            return function.apply(connection);
        }
    }

    /**
     * Runs a consumer with an acquired connection and closes the connection afterward.
     *
     * @param consumer Non-null consumer to invoke.
     * @throws SQLException If connection acquisition, consumer execution, or connection closing fails.
     */
    default void invokeWithConnection(@NonNull ConnectionConsumer<@NonNull Connection> consumer) throws SQLException {
        try (Connection connection = getConnection()) {
            consumer.accept(connection);
        }
    }
}
