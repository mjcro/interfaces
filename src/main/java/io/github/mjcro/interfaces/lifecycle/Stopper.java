package io.github.mjcro.interfaces.lifecycle;

/**
 * Defines a component that can stop.
 */
@FunctionalInterface
public interface Stopper {
    /**
     * Stops the component.
     * During shutdown, the component may clear its state,
     * close connections, flush data, etc.
     *
     * @throws Exception If the operation fails.
     */
    void stop() throws Exception;
}
