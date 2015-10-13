package com.example.alberto.tallerbinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;
import android.text.Editable;
import android.text.TextWatcher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alberto on 28/09/2015.
 */
public class TwoWayBinding extends BaseObservable {
    private String field1="";
    @Bindable
    public String getField1() {
        return field1;
    }
    public void setField1(String field1) {
        this.field1 = field1;
    }
    public TwoWayBinding(String a) {
        this.field1 = a;
    }

    public final TextWatcher field1Changed = new SimpleTextWatcher() {
        @Override
        public void onTextChanged(String newValue) {
            field1 = newValue;
            notifyPropertyChanged(com.example.alberto.tallerbinding.BR.field1);
            // el nombre de en el BR lo pilla del get
        }

    };


}

