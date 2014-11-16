package hr.simplesource.toolbelt.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * TODO commentary
 * TODO view holder pattern
 */
public abstract class SimpleUniversalAdapter<T> extends BaseAdapter implements List<T> {

    // todo
    private static abstract class ViewHolder {}

    private Context mContext;
    private List<T> objectList = new ArrayList<T>();

    private boolean mShouldNotify = true;

    public SimpleUniversalAdapter(Context context) {
        this.mContext = context;
    }

    public SimpleUniversalAdapter(Context context, List<T> objectList) {
        this.mContext = context;
        objectList.addAll(objectList);
    }

    /**
     * Enables or disables ability to automatically notifyDataSetChanged
     * for this adapter.
     *
     * @param enabled when set to false, disables automatic notification of data set changes.
     *                In this case, {@link SimpleUniversalAdapter#notifyDataSetChanged()} has to be called
     *                manually to display new or changed data
     */
    public void enableStateChangedNotification(boolean enabled) {
        this.mShouldNotify = enabled;
    }

    private void signalNotify() {
        if (mShouldNotify) notifyDataSetChanged();
    }

    public Context getContext() {
        return mContext;
    }

    @Override
    public int getCount() {
        return objectList.size();
    }

    @Override
    public T getItem(int position) {
        return objectList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return objectList.hashCode();
    }

    @Override
    public abstract View getView(int position, View convertView, ViewGroup parent);

    @Override
    public void add(int location, T object) {
        objectList.add(location, object);
        signalNotify();
    }

    @Override
    public boolean add(T object) {
        boolean result = objectList.add(object);
        signalNotify();
        return result;
    }

    @Override
    public boolean addAll(int location, Collection<? extends T> collection) {
        boolean result = objectList.addAll(location, collection);
        signalNotify();
        return result;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        boolean result = objectList.addAll(collection);
        signalNotify();
        return result;
    }

    @Override
    public void clear() {
        objectList.clear();
        signalNotify();
    }

    @Override
    public boolean contains(Object object) {
        return objectList.contains(object);
    }

    @Override
    public boolean containsAll(@NonNull Collection<?> collection) {
        return objectList.containsAll(collection);
    }

    @Override
    public T get(int location) {
        return objectList.get(location);
    }

    @Override
    public int indexOf(Object object) {
        return objectList.indexOf(object);
    }

    @Override
    @NonNull
    public Iterator<T> iterator() {
        return objectList.iterator();
    }

    @Override
    public int lastIndexOf(Object object) {
        return objectList.lastIndexOf(object);
    }

    @Override
    @NonNull
    public ListIterator<T> listIterator() {
        return objectList.listIterator();
    }

    @Override
    @NonNull
    public ListIterator<T> listIterator(int location) {
        return objectList.listIterator(location);
    }

    @Override
    public T remove(int location) {
        T result = objectList.remove(location);
        signalNotify();
        return result;
    }

    @Override
    public boolean remove(Object object) {
        boolean result = objectList.remove(object);
        signalNotify();
        return result;
    }

    @Override
    public boolean removeAll(@NonNull Collection<?> collection) {
        boolean result = objectList.removeAll(collection);
        signalNotify();
        return result;
    }

    @Override
    public boolean retainAll(@NonNull Collection<?> collection) {
        boolean result = objectList.retainAll(collection);
        signalNotify();
        return result;
    }

    @Override
    public T set(int location, T object) {
        T result = objectList.set(location, object);
        signalNotify();
        return result;
    }

    @Override
    public int size() {
        return objectList.size();
    }

    @Override
    @NonNull
    public List<T> subList(int start, int end) {
        return objectList.subList(start, end);
    }

    @Override
    @NonNull
    public Object[] toArray() {
        return objectList.toArray();
    }

    @Override
    @NonNull
    public <E> E[] toArray(@NonNull E[] array) {
        return objectList.toArray(array);
    }
}
