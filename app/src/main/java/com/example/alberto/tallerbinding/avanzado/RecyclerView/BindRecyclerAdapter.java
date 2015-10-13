package com.example.alberto.tallerbinding.avanzado.RecyclerView;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alberto.tallerbinding.R;
import com.example.alberto.tallerbinding.avanzado.RecyclerView.Model.Name;

import java.util.List;

/**
 * Created by Alberto on 11/10/2015.
 */
public class BindRecyclerAdapter extends
        RecyclerView.Adapter<BindRecyclerAdapter.BindRecyclerViewHolder> {
    public List<Name> mData;

    public BindRecyclerAdapter(List<Name> recyclerUsers) {
        this.mData = recyclerUsers;
    }

    @Override
    public BindRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        BindRecyclerViewHolder holder = new BindRecyclerViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(BindRecyclerViewHolder holder, int position) {
        final Name name = mData.get(position);
        holder.getBinding().setVariable(com.example.alberto.tallerbinding.BR.name, name);
        holder.getBinding().executePendingBindings();//pa q lo haga now

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class BindRecyclerViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public BindRecyclerViewHolder(View v) {
            super(v);
            binding = DataBindingUtil.bind(v);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }
}
