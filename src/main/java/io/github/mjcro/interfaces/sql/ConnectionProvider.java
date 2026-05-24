package io.github.mjcro.interfaces.sql;

import org.jspecify.annotations.NonNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Provides database {@link Connection} instances, with support for invoking consumers and functions
 * that operate on a connection and automatically close it afterward.
 */
@FunctionalInterface
public interface ConnectionProvider {
    /**
     * Wraps given Java supplier into ConnectionProvider wrapper.
     *
     * @param supplier Java supplier.
     * @return ConnectionProvider instance.
     */
    static @NonNull ConnectionProvider ofSupplier(final @NonNull Supplier<@NonNull Connection> supplier) {
        Objects.requireNonNull(supplier, "supplier");
        return supplier::get;
    }

    /**
     * Wraps existing connection into ConnectionProvider wrapper.
     *
     * @param connection Established connection
     * @return ConnectionProvider instance.
     */
    static @NonNull ConnectionProvider ofConnection(final @NonNull Connection connection) {
        Objects.requireNonNull(connection, "connection");
        return () -> connection;
    }

    /**
     * Constructs or pools database connection.
     *
     * @return Connection to use.
     * @throws SQLException On connection error.
     */
    @NonNull Connection getConnection() throws SQLException;

    /**
     * Runs given function passing database connection to it.
     * After invocation connection will be closed by default implementation.
     *
     * @param function Function to invoke.
     * @param <T>      Response type.
     * @return Function response.
     */
    default <T> @NonNull T invokeWithConnection(@NonNull ConnectionFunction<@NonNull Connection, @NonNull T> function) throws SQLException {
        try (Connection connection = getConnection()) {
            return function.apply(connection);
        }
    }

    /**
     * Runs given consumer passing database connection to it.
     * After invocation connection will be closed by default implementation.
     *
     * @param consumer Consumer to invoke.
     */
    default void invokeWithConnection(@NonNull ConnectionConsumer<@NonNull Connection> consumer) throws SQLException {
        try (Connection connection = getConnection()) {
            consumer.accept(connection);
        }
    }
}
