package io.github.mjcro.interfaces.lifecycle;

/**
 * Defines component capable to start.
 */
@FunctionalInterface
public interface Starter {
    /**
     * Starts component.
     * Under start procedure component may initialize it's state,
     * establish necessary connections, read data, etc.
     *
     * @throws Exception On exception.
     */
    void start() throws Exception;
}
