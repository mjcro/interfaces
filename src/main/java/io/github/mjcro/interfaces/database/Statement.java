package io.github.mjcro.interfaces.database;

import org.jspecify.annotations.NonNull;


/**
 * Represents a database statement to execute.
 */
public interface Statement {
    /**
     * Returns the SQL query for this statement.
     *
     * @return Statement query.
     */
    @NonNull String getSql();

    /**
     * Returns the parameters bound to this statement.
     *
     * @return Statement parameters.
     */
    @NonNull Object @NonNull [] getParameters();

    /**
     * Checks whether this statement has bound parameters.
     *
     * @return True if the statement has parameters, false otherwise.
     */
    @SuppressWarnings("ConstantValue")
    default boolean hasParameters() {
        Object[] parameters = getParameters();
        return parameters != null && parameters.length > 0;
    }

    /**
     * Checks whether this statement has no bound parameters.
     *
     * @return True if the statement has no parameters, false otherwise.
     */
    default boolean notHasParameters() {
        return !hasParameters();
    }
}
