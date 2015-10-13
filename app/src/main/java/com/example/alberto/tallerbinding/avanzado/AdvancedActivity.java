package com.example.alberto.tallerbinding.avanzado;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alberto.tallerbinding.R;
import com.example.alberto.tallerbinding.avanzado.RecyclerView.VMRecycler;
import com.example.alberto.tallerbinding.databinding.ActivityAdvancedBinding;
import com.example.alberto.tallerbinding.databinding.ActivityMainBinding;

public class AdvancedActivity extends AppCompatActivity {
    VMRecycler vmRecycler;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = this.getApplicationContext();
        this.vmRecycler = new VMRecycler(mContext);
        doBinding();
    }

    private void doBinding() {
        ActivityAdvancedBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_advanced);
        binding.setRecyclerVM(vmRecycler);
        binding.BindRecyclerView.setAdapter(vmRecycler.getAdapter());
    }

}
