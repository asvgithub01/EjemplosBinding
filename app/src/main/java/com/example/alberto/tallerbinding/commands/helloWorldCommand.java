package com.example.alberto.tallerbinding.commands;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Alberto on 04/10/2015.
 */
public class helloWorldCommand extends Command {
    @Override
    public void execute(View v, Object input) {

        if (input instanceof String && canIexecute())
            Toast.makeText(v.getContext(), "Ejecutando,\n HOLA "+ input.toString(), Toast.LENGTH_LONG).show();
        else
            Toast.makeText(v.getContext(), "No ejecuto, ni saludo ", Toast.LENGTH_LONG).show();

    }

    public helloWorldCommand(Context context) {
        super(context);
    }

    @Override
    public void execute(View v) {
        if (canIexecute())
            Toast.makeText(v.getContext(), "Son minutos pares, ejecutando, HOLA MUNDO", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(v.getContext(), "Minutos impares, no ejecuto", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean canIexecute() {
        Calendar calendar = Calendar.getInstance();
        int Minutes = calendar.get(Calendar.MINUTE);

        //simplemente comprobamos si es par o impar para q el execute saque distintas repuestas
        if ((Minutes % 2) == 0)
            return true;
        else
            return false;
    }
}
