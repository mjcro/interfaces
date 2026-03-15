package io.github.mjcro.interfaces.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Consumer that allows SQL exception to be thrown.
 */
@FunctionalInterface
public interface ConnectionConsumer<C extends Connection> {
    /**
     * Constructs consumer that allows SQL exception
     * to be thrown from common consumer.
     *
     * @param consumer Consumer to wrap.
     * @return Consumer that allows SQL exception to be thrown.
     */
    static <C extends Connection> ConnectionConsumer<C> ofConsumer(Consumer<? super C> consumer) {
        Objects.requireNonNull(consumer, "consumer");
        return consumer::accept;
    }

    /**
     * Performs this operation on the given connection.
     *
     * @param c Database connection.
     * @throws SQLException If a database error occurs.
     */
    void accept(C c) throws SQLException;
}
