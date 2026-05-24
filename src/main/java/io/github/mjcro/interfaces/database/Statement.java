package io.github.mjcro.interfaces.database;

import org.jspecify.annotations.NonNull;


/**
 * Represents database statement to make.
 */
public interface Statement {
    /**
     * @return Statement query.
     */
    @NonNull String getSql();

    /**
     * @return Statement parameters.
     */
    @NonNull Object @NonNull [] getParameters();

    /**
     * @return True if statement has parameters, false otherwise.
     */
    @SuppressWarnings("ConstantValue")
    default boolean hasParameters() {
        Object[] parameters = getParameters();
        return parameters != null && parameters.length > 0;
    }

    /**
     * @return True if statement has no parameters, false otherwise.
     */
    default boolean notHasParameters() {
        return !hasParameters();
    }
}
