package com.example.alberto.tallerbinding.avanzado.RecyclerView;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.alberto.tallerbinding.R;
import com.example.alberto.tallerbinding.Utils;
import com.example.alberto.tallerbinding.avanzado.RecyclerView.Model.Name;
import com.example.alberto.tallerbinding.commands.Command;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Alberto on 09/10/2015.
 */
public class VMRecycler extends BaseObservable {

    private BindRecyclerAdapter mBindRecyclerAdapter;//ejemplo1
    private RecyclerAdapter mRecyclerAdapter;//ejemplo2

    private Context mContext;

    public VMRecycler(Context context) {
        this.mContext = context;
        this.mBindRecyclerAdapter = new BindRecyclerAdapter(createData(5));

        this.mRecyclerAdapter = new RecyclerAdapter<Name>(createData(5),
                R.layout.item_recycler_new,
                com.example.alberto.tallerbinding.BR.itemdata, new itemDataCommand(mContext));
    }

    private List<Name> createData(final int numRegs) {
        List<Name> returnData = new ArrayList<Name>() {{
            for (int i = 0; i < numRegs; i++) {

                add(new Name() {{
                    setTitle(Utils.getRandomTitle());
                    setFirst(Utils.getRandomName());
                    setLast(Utils.getRandomSurName());
                }});

            }
        }};

        return returnData;
    }

    //region ejemplo1
    public RecyclerView.Adapter getAdapter() {
        return this.mBindRecyclerAdapter;
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(mContext);
    }
    //endregion

    //region ejemplo2

    public RecyclerView.Adapter getMyAdapter() {
        return this.mRecyclerAdapter;
    }

    public RecyclerView.LayoutManager getMyLayoutManager() {
        return new LinearLayoutManager(mContext);
    }

    public class itemDataCommand extends Command {
        @Override
        public void execute(View v, Object input) {

            if (input instanceof Name && canIexecute())
                Toast.makeText(v.getContext(), "Ejecutando,\n HOLA " +
                        ((Name) input).getTitle() + ((Name) input).getFirst()
                        + ((Name) input).getLast().toString(), Toast.LENGTH_LONG).
                        show();
        }

        public itemDataCommand(Context context) {
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

    //endregion
}

