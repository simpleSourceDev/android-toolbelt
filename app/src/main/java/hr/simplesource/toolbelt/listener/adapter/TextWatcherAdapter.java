package hr.simplesource.toolbelt.listener.adapter;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Adapter class that implements all methods from {@link android.text.TextWatcher}.
 * Typically used instead of TextWatcher when only one of all methods is going to be used.
 */
public abstract class TextWatcherAdapter implements TextWatcher {

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
