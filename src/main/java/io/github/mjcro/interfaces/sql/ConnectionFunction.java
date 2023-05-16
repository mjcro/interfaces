package io.github.mjcro.interfaces.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.function.Function;

/**
 * Function that allows SQL exception to be thrown.
 */
@FunctionalInterface
public interface ConnectionFunction<C extends Connection, R> {
    /**
     * Constructs function that allows SQL exception
     * to be thrown from common function.
     *
     * @param function Function to wrap.
     * @return Function that allows SQL exception to be thrown.
     */
    static <C extends Connection, R> ConnectionFunction<C, R> ofFunction(Function<? super C, ? extends R> function) {
        Objects.requireNonNull(function, "function");
        return function::apply;
    }

    R apply(C c) throws SQLException;
}
