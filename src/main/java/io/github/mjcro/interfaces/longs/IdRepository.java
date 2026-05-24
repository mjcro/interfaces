package io.github.mjcro.interfaces.longs;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Generic repository for entities identified by a {@code long} identifier.
 *
 * @param <T> Entity type, must implement {@link WithId}.
 */
public interface IdRepository<T extends WithId> {
    /**
     * Fetches collection of entities with given identifiers.
     *
     * @param ids Identifiers to find.
     * @return Non-null list of found entities. If none found empty list is returned.
     */
    @NonNull List<@NonNull T> findById(long @NonNull [] ids);




    /* Collection aliases block */

    /**
     * Fetches collection of entities with given identifiers.
     *
     * @param ids Identifiers to find, may be null.
     * @return Non-null list of found entities. If none found empty list is returned.
     */
    default @NonNull List<@NonNull T> findById(@Nullable Collection<@NonNull Long> ids) {
        if (ids == null || ids.isEmpty()) {
            return Collections.emptyList();
        }

        return findById(ids.stream().mapToLong($ -> $).distinct().toArray());
    }

    /**
     * Returns all entities for requested identifiers.
     *
     * @param ids Identifiers to find.
     * @return List of identifier.
     * @throws RuntimeException If one or more entities with requested identifiers missing.
     */
    default @NonNull List<@NonNull T> mustFindById(long @NonNull [] ids) {
        List<T> results = findById(ids);
        if (results.size() != ids.length && results.size() != Arrays.stream(ids).distinct().count()) {
            Set<Long> requested = Arrays.stream(ids).boxed().collect(Collectors.toSet());
            results.stream().map(WithId::getId).collect(Collectors.toList()).forEach(requested::remove);
            throw this.exceptionForMissingEntities(requested.stream().mapToLong($ -> $).toArray());
        }
        return results;
    }

    /**
     * Returns all entities for requested identifiers.
     *
     * @param ids Identifiers to find, may be null.
     * @return List of entities.
     * @throws RuntimeException If one or more entities with requested identifiers missing.
     */
    default @NonNull List<@NonNull T> mustFindById(@Nullable Collection<@NonNull Long> ids) {
        if (ids == null || ids.isEmpty()) {
            return Collections.emptyList();
        }

        return mustFindById(ids.stream().mapToLong($ -> $).toArray());
    }




    /* Single ID block */

    /**
     * Returns entity by its identifier.
     *
     * @param id Identifier to find.
     * @return Optional entity.
     */
    default @NonNull Optional<@NonNull T> findById(long id) {
        return findById(new long[]{id}).stream().findFirst();
    }

    /**
     * Returns entity by its identifier.
     *
     * @param id Identifier to find.
     * @return Entity.
     * @throws RuntimeException If entity not found.
     */
    default @NonNull T mustFindById(long id) {
        Optional<T> found = findById(id);
        if (found.isPresent()) {
            return found.get();
        }
        throw exceptionForMissingEntities(new long[]{id});
    }




    /* Maps block */

    /**
     * Returns map of entities classified by id.
     *
     * @param ids Identifiers to find.
     * @return Map of entities, where keys are entity ids.
     */
    default @NonNull Map<@NonNull Long, @NonNull T> mapById(long @NonNull [] ids) {
        return findById(ids).stream().collect(Collectors.toMap(WithId::getId, Function.identity()));
    }

    /**
     * Returns map of entities classified by id.
     *
     * @param ids Identifiers to find.
     * @return Map of entities, where keys are entity ids.
     */
    default @NonNull Map<@NonNull Long, @NonNull T> mapById(@NonNull Collection<@NonNull Long> ids) {
        return mapById(ids.stream().mapToLong($ -> $).toArray());
    }

    /**
     * Returns map of entities classified by id.
     *
     * @param ids Identifiers to find.
     * @return Map of entities, where keys are entity ids.
     * @throws RuntimeException If one or more entities with requested identifiers missing.
     */
    default @NonNull Map<@NonNull Long, @NonNull T> mustMapById(long @NonNull [] ids) {
        return mustFindById(ids).stream().collect(Collectors.toMap(WithId::getId, Function.identity()));
    }

    /**
     * Returns map of entities classified by id.
     *
     * @param ids Identifiers to find.
     * @return Map of entities, where keys are entity ids.
     * @throws RuntimeException If one or more entities with requested identifiers missing.
     */
    default @NonNull Map<@NonNull Long, @NonNull T> mustMapById(@NonNull Collection<@NonNull Long> ids) {
        return mustMapById(ids.stream().mapToLong($ -> $).toArray());
    }




    /* Utility block */

    /**
     * Constructs exception to throw when one or more identifiers was not
     * matched.
     *
     * @param ids Missing identifiers.
     * @return Exception to throw.
     */
    default @NonNull RuntimeException exceptionForMissingEntities(long @NonNull [] ids) {
        return ids.length == 1
                ? new RuntimeException("Unable to find entity with id " + ids[0])
                : new RuntimeException("Unable to find entities with ids " + Arrays.stream(ids).boxed().map(Object::toString).collect(Collectors.joining(",")));
    }
}
