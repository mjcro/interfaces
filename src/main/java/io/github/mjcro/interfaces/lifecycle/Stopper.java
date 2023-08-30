package io.github.mjcro.interfaces.lifecycle;

/**
 * Defines component capable to start.
 */
@FunctionalInterface
public interface Stopper {
    /**
     * Stops component.
     * Under stop procedure component may clear it's state,
     * close connections, flush data, etc.
     *
     * @throws Exception On exception.
     */
    void stop() throws Exception;
}
