package io.github.mjcro.interfaces.lifecycle;

/**
 * Defines a component that can start.
 */
@FunctionalInterface
public interface Starter {
    /**
     * Starts the component.
     * During startup, the component may initialize its state,
     * establish necessary connections, read data, etc.
     *
     * @throws Exception If the operation fails.
     */
    void start() throws Exception;
}
