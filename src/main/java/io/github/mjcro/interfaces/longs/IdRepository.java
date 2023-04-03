package io.github.mjcro.interfaces.longs;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface IdRepository<T extends WithId> {
    /**
     * Fetches collection of entities with given identifiers.
     *
     * @param ids Identifiers to find.
     * @return Non-null list of found entities. If none found empty list is returned.
     */
    List<T> findById(long[] ids);

    /**
     * Fetches collection of entities with given identifiers.
     *
     * @param ids Identifiers to find.
     * @return Non-null list of found entities. If none found empty list is returned.
     */
    default List<T> findById(Collection<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            return Collections.emptyList();
        }

        return findById(ids.stream().mapToLong($ -> $).toArray());
    }

    /**
     * Returns entry by it's IDs.
     *
     * @param ids IDs to find
     * @return List of entries
     */
    default List<T> mustFindByIds(long[] ids) {
        List<T> results = findById(ids);
        if (results.size() != ids.length && results.size() != Arrays.stream(ids).distinct().count()) {
            Set<Long> requested = Arrays.stream(ids).boxed().collect(Collectors.toSet());
            requested.removeAll(results.stream().map(WithId::getId).collect(Collectors.toList()));
            throw new RuntimeException();
        }
        return results;
    }

    /**
     * Returns entity by its identifier.
     *
     * @param id Identifier to find.
     * @return Optional entity.
     */
    default Optional<T> findById(long id) {
        List<T> results = findById(new long[]{id});
        if (results.size() == 0) {
            return Optional.empty();
        } else if (results.size() > 1) {
            throw new RuntimeException("Received multiple entries for single entry request");
        } else if (results.get(0).getId() != id) {
            throw new RuntimeException(String.format(
                    "Fatal inconsistency. For ID %d received entry with ID %d",
                    id,
                    results.get(0).getId()
            ));
        }

        return Optional.of(results.get(0));
    }

    /**
     * Returns entry by it's ID.
     *
     * @param id ID to locate
     * @return Found entry
     */
    default T mustFindById(long id) {
        return findById(id).get();
    }

    /**
     * Returns maps of entries classified by id.
     *
     * @param ids Identifiers to search
     * @return Data map
     */
    default Map<Long, T> mapById(long[] ids) {
        return findById(ids).stream().collect(Collectors.toMap(WithId::getId, Function.identity()));
    }

    /**
     * Returns maps of entries classified by id.
     *
     * @param ids Identifiers to search
     * @return Data map
     */
    default Map<Long, T> mapById(final Collection<Long> ids) {
        return findById(ids).stream().collect(Collectors.toMap(WithId::getId, Function.identity()));
    }
}
