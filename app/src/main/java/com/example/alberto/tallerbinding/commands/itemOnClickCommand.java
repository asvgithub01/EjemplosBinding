package com.example.alberto.tallerbinding.commands;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alberto.tallerbinding.R;
import com.example.alberto.tallerbinding.avanzado.RecyclerView.Model.Name;
import com.example.alberto.tallerbinding.databinding.ActivityMainBinding;
import com.example.alberto.tallerbinding.databinding.ItemEditableBinding;

import java.util.Calendar;

/**
 * Created by Alberto on 22/10/2015.
 */
public class itemOnClickCommand  extends Command {
    @Override
    public void execute(View v, Object input) {
        if (input instanceof Name) {
            //1ºinflate template
           View content= inflateEditItem((Name) input);
            addField4Reflection(content,(Name) input);
            //2ºanimacion del template

        }


    }

    private void addField4Reflection(View content,Name name) {


    }

    ItemEditableBinding binding;
    private View inflateEditItem(Name name) {
          binding = DataBindingUtil.setContentView((Activity) mContext, R.layout.item_editable);
        binding.editTitle.setHint(name.getTitle());
        return binding.content;
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

