package io.github.mjcro.interfaces.ints;

/**
 * Mixin interface for entities that carry an integer ordering value.
 */
public interface WithOrder {
    /**
     * Returns the entity ordering value.
     *
     * @return Order of entity
     */
    int getOrder();
}
