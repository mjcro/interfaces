package io.github.mjcro.interfaces.sql;

import java.sql.Connection;
import java.sql.SQLException;

public interface WithConnection {
    /**
     * Constructs or return returns existing database connection.
     *
     * @return Database connection.
     * @throws SQLException On database error.
     */
    Connection getConnection() throws SQLException;
}
