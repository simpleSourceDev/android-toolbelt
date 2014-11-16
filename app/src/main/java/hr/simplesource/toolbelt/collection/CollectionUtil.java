package hr.simplesource.toolbelt.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Collection of utility methods involving any kind of
 * common task related to Java Collections
 */
public class CollectionUtil {

    /**
     * Takes any collection and turns it into an {@link java.util.ArrayList}
     * @param collection
     * @param <E>
     * @return
     */
    public static <E> ArrayList<E> asArrayList(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>();
        arrayList.addAll(collection);
        return arrayList;
    }

    /**
     * Filters the given list by removing all elements which do not
     * pass a condition set in the {@link hr.simplesource.toolbelt.collection.Filter}.
     * <br/> <br/>
     * This method is more suited for those situations that have to explicitly remove
     * data by given condition. For situations where you want to keep elements
     * that satisfy the condition, use {@link hr.simplesource.toolbelt.collection.CollectionUtil#stream(java.util.List, Filter)}
     * @param list a list of data which will be filtered (in the same instance)
     * @param filter Filter that should return <b>true</b> for elements which <b>have to be removed.</b>
     *               For example, if a list of positive integer numbers has to filter out all odd numbers,
     *               this filter should return true for each odd number.
     * @param <E> type of element
     */
    public static <E> void filterList(List<E> list, Filter<E> filter) {
        for (int i = 0; i < list.size(); i++) {
            if (filter.onElement(list.get(i))) {
                list.remove(i);
                i--;
            }
        }
    }

    /**
     * Filters the list by a given condition and returns a new {@link java.util.List} holding only
     * those elements that satisfy the condition given by the {@link hr.simplesource.toolbelt.collection.Filter
     * @param list list which will be streamed and filtered. Instance of this list will not be returned.
     * @param filter Filter holding a condition which has to be satisfied in order for elements
     *               from list to be applied in return list
     * @param <E> type of element
     * @return a new list holding only those elements which were successfully filtered by provided
     * filter
     */
    public static <E> List<E> stream(List<E> list, Filter<E> filter) {
        List<E> resultList = new ArrayList<>();
        for (E element : list) {
            if (filter.onElement(element)) {
                resultList.add(element);
            }
        }
        return resultList;
    }

}
