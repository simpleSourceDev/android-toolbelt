package hr.simplesource.toolbelt.listener.adapter;

import android.view.View;
import android.widget.AdapterView;

/**
 * Abstract adapter class for interface {@link android.widget.AdapterView.OnItemSelectedListener}
 */
public abstract class OnItemSelectedListenerAdapter implements AdapterView.OnItemSelectedListener {

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
