package com.example.nowor_000.vistasbasicas;

import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;

/**
 * Created by nowor_000 on 08/12/2015.
 */
public class Permiso {


    public Permiso() {

    }

    public void deshabilitar( RadioButton radio1, RadioButton radio2, RadioButton radio3,  Switch switchLintena,Spinner spinner1,Spinner spinner2){
        radio1.setEnabled(false);
        radio2.setEnabled(false);
        radio3.setEnabled(false);
        switchLintena.setEnabled(false);
        spinner1.setEnabled(false);
        spinner2.setEnabled(false);

    }

    public void habilitar( RadioButton radio1, RadioButton radio2, RadioButton radio3, Switch switchLintena,Spinner spinner1,Spinner spinner2){

        radio1.setEnabled(true);
        radio2.setEnabled(true);
        radio3.setEnabled(true);

        switchLintena.setEnabled(true);
        spinner1.setEnabled(true);
        spinner2.setEnabled(true);


    }



}
