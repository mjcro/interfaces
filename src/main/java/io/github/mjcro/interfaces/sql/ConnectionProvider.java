package io.github.mjcro.interfaces.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@FunctionalInterface
public interface ConnectionProvider {
    /**
     * Wraps given Java supplier into ConnectionProvider wrapper.
     *
     * @param supplier Java supplier.
     * @return ConnectionProvider instance.
     */
    static ConnectionProvider ofSupplier(final Supplier<Connection> supplier) {
        Objects.requireNonNull(supplier, "supplier");
        return supplier::get;
    }

    /**
     * Wraps existing connection into ConnectionProvider wrapper.
     *
     * @param connection Established connection
     * @return ConnectionProvider instance.
     */
    static ConnectionProvider ofConnection(final Connection connection) {
        Objects.requireNonNull(connection, "connection");
        return () -> connection;
    }

    /**
     * Constructs or pools database connection.
     *
     * @return Connection to use.
     * @throws SQLException On connection error.
     */
    Connection getConnection() throws SQLException;

    /**
     * Runs given function passing database connection to it.
     * After invocation connection will be closed by default implementation.
     *
     * @param function Function to invoke.
     * @param <T>      Response type.
     * @return Function response.
     */
    default <T> T invokeWithConnection(Function<Connection, T> function) throws SQLException {
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
    default void invokeWithConnection(Consumer<Connection> consumer) throws SQLException {
        this.invokeWithConnection(connection -> {
            consumer.accept(connection);
            return null;
        });
    }
}