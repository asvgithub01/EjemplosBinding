package com.example.alberto.tallerbinding.avanzado.RecyclerView.Model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextWatcher;

import com.example.alberto.tallerbinding.SimpleTextWatcher;



/**
 * Created by Alberto on 09/10/2015.
 */
public class NameEditable extends BaseObservable {

    private String title;
    private String first;
    private String last;

    @Bindable
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }
    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }
    public void setLast(String last) {
        this.last = last;
    }


}
