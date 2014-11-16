package hr.simplesource.toolbelt.collection;

/**
 * An interface used to filter stream of data in one collection.
 * @param <E> an element of a Collection
 */
public interface Filter<E> {
    /**
     * Takes an element as a parameter and filters it out based on
     * implemented logic.
     * @param element current element of a stream of one collection
     * @return if this element should be filtered (kept or removed, depending on
     *          a context where this interface is implemented, return <b>true</b>, otherwise
     *          return <b>false</b> and current element will be skipped
     */
    boolean onElement(E element);
}
