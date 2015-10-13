package com.example.alberto.tallerbinding.commands;

import android.content.Context;
import android.view.View;

/**
 * Created by Alberto on 04/10/2015.
 */
public class AsyncCommand extends Command {
    public AsyncCommand(Context context) {
        super(context);
    }

    @Override
    public void execute(View v, Object input) {

    }

    @Override
    public void execute(View v) {
    }

    @Override
    public boolean canIexecute() {
        return false;
    }
}
