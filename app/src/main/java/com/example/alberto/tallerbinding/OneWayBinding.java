package com.example.alberto.tallerbinding;

import android.databinding.BaseObservable;
import android.text.TextWatcher;

/**
 * Created by Alberto on 28/09/2015.
 */
public class OneWayBinding  {
    private final String field1;
    private final String field2;

    public OneWayBinding(String a, String b) {
        this.field1 = a;
        this.field2 = b;
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }
}
