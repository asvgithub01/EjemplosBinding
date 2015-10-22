package com.example.alberto.tallerbinding.commands;

import android.content.Context;
import android.view.View;

/**
 * Created by Alberto on 22/10/2015.
 */
public class itemSaveCommand extends Command {
    @Override
    public void execute(View v, Object input) {

        //1ºinflate template
        //2ºanimacion del template

    }

    public itemSaveCommand(Context context) {
        super(context);
    }

    @Override
    public void execute(View v) {

    }

    @Override
    public boolean canIexecute() {

        return true;
    }
}
