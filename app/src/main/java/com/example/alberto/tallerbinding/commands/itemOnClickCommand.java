package com.example.alberto.tallerbinding.commands;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Alberto on 22/10/2015.
 */
public class itemOnClickCommand extends Command {
    @Override
    public void execute(View v, Object input) {

    }

    public itemOnClickCommand(Context context) {
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
