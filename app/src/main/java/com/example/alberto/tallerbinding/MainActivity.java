package com.example.alberto.tallerbinding;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableBoolean;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.example.alberto.tallerbinding.avanzado.RecyclerView.VMRecycler;
import com.example.alberto.tallerbinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    TwoWayFunctions func = new TwoWayFunctions();
    OneWayBinding oneway = new OneWayBinding("ONE", "WAY");
    TwoWayBinding twoWayBinding = new TwoWayBinding("twoways");
    public static Context mContext; //sacrilegio!
    //advanced


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext= this.getApplicationContext();

        doBinding();
    }

    private void doBinding() {
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setOneway(oneway);
        binding.setFunc(func);
        binding.setTwoway(twoWayBinding);
        binding.setActivity(this);//esta linea es fundamental xa q ejecute el binding de cualquier tipo
        //eventos tipo3
        binding.btnTipo3.setOnClickListener(func.getOnClickInsertarListener());


        //advanced
        VMRecycler vmRecycler = new VMRecycler(mContext);
        binding.setRecyclerVM(vmRecycler);
        binding.BindRecyclerView.setAdapter(vmRecycler.getAdapter());
        binding.BindRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public String getStrTestContexto() {
        return  strTestContexto;
    }

    private String strTestContexto="Demo de OneWayDEsde Activity look Dobinding y el button";


    //region prueba que no funciona de un observableType
/*
El uso de observableTypes era por ver si es posible un 2ways sin extender de BaseObserver
(el notifyPropertyChanged es de Base Observer)
No funciona, no actualiza el valor
*/
    public ObservableBoolean isObjectVisible;

    public ObservableBoolean getisObjectVisible() {

        return isObjectVisible;
    }

    public void setIsObjectVisible(ObservableBoolean bool) {
        this.isObjectVisible = bool;

    }

//endregion

    //region android studio
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //endregion


}
