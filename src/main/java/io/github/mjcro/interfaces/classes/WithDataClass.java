package io.github.mjcro.interfaces.classes;

/**
 * Mixin interface for entities that expose a data class descriptor.
 */
public interface WithDataClass {
    /**
     * @return Data class.
     */
    Class<?> getDataClass();
}
