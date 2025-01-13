package io.github.mjcro.interfaces.database;

/**
 * Represents database statement to make.
 */
public interface Statement {
    /**
     * @return Statement query.
     */
    String getSql();

    /**
     * @return Statement parameters.
     */
    Object[] getParameters();

    /**
     * @return True if statement has parameters, false otherwise.
     */
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
