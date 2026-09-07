package io.github.mjcro.interfaces.database;

import org.jspecify.annotations.NonNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Operation that accepts a non-null JDBC {@link Connection} and may throw an
 * {@link SQLException}.
 *
 * @param <C> Connection type accepted by this consumer. Must not be null.
 */
@FunctionalInterface
public interface ConnectionConsumer<C extends Connection> {
    /**
     * Adapts a standard consumer to a connection consumer.
     *
     * @param consumer Non-null consumer to adapt.
     * @param <C>      Non-null connection type accepted by the consumer.
     * @return Non-null connection consumer backed by the given consumer.
     * @throws NullPointerException If {@code consumer} is null.
     */
    static <C extends Connection> @NonNull ConnectionConsumer<@NonNull C> ofConsumer(@NonNull Consumer<? super @NonNull C> consumer) {
        Objects.requireNonNull(consumer, "consumer");
        return consumer::accept;
    }

    /**
     * Performs this operation on a non-null connection.
     *
     * @param c Non-null database connection.
     * @throws SQLException If a database error occurs.
     */
    void accept(@NonNull C c) throws SQLException;
}
