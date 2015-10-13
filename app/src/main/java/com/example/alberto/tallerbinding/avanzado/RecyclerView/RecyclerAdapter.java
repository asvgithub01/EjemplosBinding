package com.example.alberto.tallerbinding.avanzado.RecyclerView;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.alberto.tallerbinding.commands.Command;

import java.util.List;


/**
 * Created by Alberto on 12/10/2015.
 */


//todo para que sea aun más versatil y escalable lo siguiente sería sustituir el uso de un mData por
//un viewmodel data q tenga dentro el mData y así incluir cualkier numero de commands, para por ejempllo establecer
//un click a los elemnetos interiores del item_recycler_new
public class RecyclerAdapter<T> extends
        RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    List<T> mData;
    int mResId;
    int mNameOfBindUX = com.example.alberto.tallerbinding.BR.name;
    final Command mCommandOnItem;

    public RecyclerAdapter(List<T> dataList, int resId, int nameOfBindUX, Command command) {
        this.mData = dataList;
        this.mResId = resId;
        this.mNameOfBindUX = nameOfBindUX;
        this.mCommandOnItem = command;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        View v = LayoutInflater.from(parent.getContext()).inflate(mResId, parent, false);
        RecyclerViewHolder holder = new RecyclerViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        final T itemData = mData.get(position);
        holder.getBinding().setVariable(mNameOfBindUX, itemData);
        holder.getBinding().executePendingBindings();
        if (mCommandOnItem != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCommandOnItem.execute(v, itemData);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class RecyclerViewHolder
            extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public RecyclerViewHolder(View v) {
            super(v);
            binding = DataBindingUtil.bind(v);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }
}

