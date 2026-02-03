package io.github.mjcro.interfaces.longs;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface StrongLongIdRepository<I extends StrongLongId, T extends WithStrongLongId<I>> {
    /**
     * Fetches collection of entities with given identifiers.
     *
     * @param ids Identifiers to find.
     * @return Non-null list of found entities. If none found empty list is returned.
     */
    List<T> findById(Collection<I> ids);

    /**
     * Returns all entities for requested identifiers.
     *
     * @param ids Identifiers to find.
     * @return List of identifier.
     * @throws RuntimeException If one or more entities with requested identifiers missing.
     */
    default List<T> mustFindById(Collection<I> ids) {
        List<T> results = findById(ids);
        if (results.size() != ids.size() && results.size() != ids.stream().distinct().count()) {
            Set<I> requested = new HashSet<>(ids);
            results.stream().map(WithStrongLongId::getId).collect(Collectors.toList()).forEach(requested::remove);
            throw this.exceptionForMissingEntities(requested);
        }
        return results;
    }




    /* Single ID block */

    /**
     * Returns entity by its identifier.
     *
     * @param id Identifier to find.
     * @return Optional entity.
     */
    default Optional<T> findById(I id) {
        return findById(Collections.singleton(id)).stream().findFirst();
    }

    /**
     * Returns entity by its identifier.
     *
     * @param id Identifier to find.
     * @return Entity.
     * @throws RuntimeException If entity not found.
     */
    default T mustFindById(I id) {
        Optional<T> found = findById(id);
        if (found.isPresent()) {
            return found.get();
        }
        throw exceptionForMissingEntities(Collections.singleton(id));
    }




    /* Maps block */

    /**
     * Returns map of entities classified by id.
     *
     * @param ids Identifiers to find.
     * @return Map of entities, where keys are entity ids.
     */
    default Map<I, T> mapById(Collection<I> ids) {
        return findById(ids).stream().collect(Collectors.toMap(WithStrongLongId::getId, Function.identity()));
    }

    /**
     * Returns map of entities classified by id.
     *
     * @param ids Identifiers to find.
     * @return Map of entities, where keys are entity ids.
     * @throws RuntimeException If one or more entities with requested identifiers missing.
     */
    default Map<I, T> mustMapById(Collection<I> ids) {
        return mustFindById(ids).stream().collect(Collectors.toMap(WithStrongLongId::getId, Function.identity()));
    }

    /**
     * Constructs exception to throw when one or more identifiers was not
     * matched.
     *
     * @param ids Missing identifiers.
     * @return Exception to throw.
     */
    default RuntimeException exceptionForMissingEntities(Collection<I> ids) {
        return ids.size() == 1
                ? new RuntimeException("Unable to find entity with id " + ids.iterator().next())
                : new RuntimeException("Unable to find entities with ids " + ids.stream().map(Object::toString).collect(Collectors.joining(",")));
    }
}
