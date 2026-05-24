package io.github.mjcro.interfaces.sql;

import org.jspecify.annotations.NonNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Consumer that can throw {@link SQLException}.
 */
@FunctionalInterface
public interface ConnectionConsumer<C extends Connection> {
    /**
     * Constructs consumer that allows SQL exception
     * to be thrown from a standard consumer.
     *
     * @param consumer Consumer to wrap.
     * @return Consumer that can throw {@link SQLException}.
     */
    static <C extends Connection> @NonNull ConnectionConsumer<@NonNull C> ofConsumer(@NonNull Consumer<? super @NonNull C> consumer) {
        Objects.requireNonNull(consumer, "consumer");
        return consumer::accept;
    }

    /**
     * Performs this operation on the given connection.
     *
     * @param c Database connection.
     * @throws SQLException If a database error occurs.
     */
    void accept(@NonNull C c) throws SQLException;
}
