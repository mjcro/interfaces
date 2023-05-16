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

    void accept(C c) throws SQLException;
}
