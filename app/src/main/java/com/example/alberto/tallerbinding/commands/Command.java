package com.example.alberto.tallerbinding.commands;

import android.content.Context;
import android.view.View;

/**
 * Created by Alberto on 04/10/2015.
 */
public abstract class Command<T> {
    Context mContext;
    public Command(Context context){
        this.mContext=context;
    }
    public abstract void execute(View v);
    public abstract void execute(View v, T input);
    public abstract boolean canIexecute();
}
