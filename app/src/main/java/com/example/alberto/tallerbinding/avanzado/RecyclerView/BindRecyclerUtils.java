package com.example.alberto.tallerbinding.avanzado.RecyclerView;

import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.alberto.tallerbinding.avanzado.RecyclerView.Model.Name;
import com.example.alberto.tallerbinding.commands.Command;



/**
 * Created by Alberto on 11/10/2015.
 */
public class BindRecyclerUtils {
    @BindingAdapter("bind:setRecyclerBinding")
    public static void setBindingRecycler(RecyclerView recyclerView,
                                          RecyclerView.Adapter<BindRecyclerAdapter.BindRecyclerViewHolder> adapter) {
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    }

    @BindingAdapter("bind:setBindingAdapter")
    public static void setBindingAdapter(RecyclerView recyclerView,
                                         RecyclerView.Adapter<BindRecyclerAdapter.BindRecyclerViewHolder> adapter) {
        recyclerView.setAdapter(adapter);

    }
    public static enum TypeLayoutManager {
        LINEAR,
        STAGERED,
        GRID
    }

    @BindingAdapter("bind:setBindingLayoutManager")
    public static void setBindingLayoutManager(RecyclerView recyclerView,
                                               RecyclerView.LayoutManager layoutManager) {
        recyclerView.setLayoutManager(layoutManager);
    }



    //todo no se utilizan, se hace a traves del RecyclerAdapter
    @BindingAdapter("bind:commandOnItemClick")
    public static void setCommandOnItemclick(View v, final Command command) {
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                command.execute(v);
            }
        });


    }

    @BindingAdapter({"bind:commandOnItemClick","bind:commandParam"})
    public static void setCommandOnItemclickWithParam(View v, final Command command, final Object o) {
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                command.execute(v, o);
            }
        });


    }


  //  @BindingAdapter({"bind:LayoutManager4StaticRecy","bind:mdata","bind:NmaevaRIABLEbINGIN","bind:itemtemplate"})
  //  public static void setBindingLayoutManager(RecyclerView recyclerView,RecyclerView.LayoutManager layoutManager,List<T> mdata,) {

        //RecyclerAdapter<Name> recyclerAdapter = new RecyclerAdapter<Name>();

      //  recyclerView.setLayoutManager(layoutManager);
    //}



}
