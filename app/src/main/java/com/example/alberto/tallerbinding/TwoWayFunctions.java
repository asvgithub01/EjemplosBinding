package com.example.alberto.tallerbinding;

import android.content.DialogInterface;
import android.database.Observable;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableChar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

/**
 * Created by Alberto on 28/09/2015.
 */
public class TwoWayFunctions extends BaseObservable {

    //region Label CheckBox
    private static String baseCheckLabel = "label";
    private String checkLabel = baseCheckLabel;

    public String getCheckLabel() {
        return checkLabel;
    }

    public void setCheckLabel(String checkLabel) {
        this.checkLabel = checkLabel;
    }

    //endregion

    //region Evento para el checkBox
    public CompoundButton.OnCheckedChangeListener myCheckListener() {
        return new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(buttonView.getContext(), "Hago esto sin saber si es el hilo ppal o no", Toast.LENGTH_LONG).show();
                checkLabel = baseCheckLabel + isChecked;
                setIsVisible(isChecked);

            }
        };
    }
    //endregion

    //region Campo que establece la visibilidad del textview mediante Expression Language
    @Bindable
    public boolean getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
        this.notifyPropertyChanged(com.example.alberto.tallerbinding.BR.isVisible);
    }

    public boolean isVisible;
    //endregion

    //region btnLabel

    public static String litBorrar = "Borrar";

    public CompoundButton.OnClickListener onClickBorrarListener;

    public CompoundButton.OnClickListener getOnClickBorrarListener() {
        return onClickBorrarListener;
    }

    public void setOnClickBorrarListener() {
        onClickBorrarListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBtnLabel(litBorrar);
            }
        };
    }

    public CompoundButton.OnClickListener getOnClickInsertarListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setBtnLabel("Insertar");
                notifyPropertyChanged(BR.btnLabel);

                Toast.makeText(v.getContext(), "getOnClickInsertarListener por tipo 3", Toast.LENGTH_LONG).show();
            }
        };
    }


    //region Label del Boton
    @Bindable
    public String getBtnLabel() {
        return btnLabel;
    }

    public void setBtnLabel(String btnLabel) {
        this.btnLabel = btnLabel;
        notifyPropertyChanged(BR.btnLabel);
    }

    private String btnLabel = "";


    //endregion

    //endregion
}
