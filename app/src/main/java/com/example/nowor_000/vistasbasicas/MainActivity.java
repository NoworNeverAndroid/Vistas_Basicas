package com.example.nowor_000.vistasbasicas;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    Permiso permisoObj;


    private CheckBox checkHabilitador;
    private LinearLayout linearGeneral;
    private RadioGroup radioGroup;
    private RadioButton radioRojo, radioVerde, radioAzul;
    private Switch switchButton;
    private Spinner spinnerEquipos, spinnerJugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializar_componentes();
        inicializar_metodos();

        permisoObj= new Permiso();
        permisoObj.deshabilitar(radioRojo, radioVerde, radioAzul, switchButton, spinnerEquipos, spinnerJugadores);




    }


    public void inicializar_componentes(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        checkHabilitador= (CheckBox) findViewById(R.id.checkBox1);
        linearGeneral=(LinearLayout)findViewById(R.id.LinearGeneral);

        radioGroup=(RadioGroup) findViewById(R.id.radioGroup);

        radioAzul=(RadioButton) findViewById(R.id.radio1);
        radioRojo=(RadioButton) findViewById(R.id.radio2);
        radioVerde=(RadioButton)findViewById(R.id.radio3);

        switchButton =(Switch) findViewById(R.id.switch1);
        spinnerEquipos =(Spinner) findViewById(R.id.spinner1);
        spinnerJugadores =(Spinner) findViewById(R.id.spinner2);
    }

    public void inicializar_metodos() {


        checkHabilitador.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    permisoObj.habilitar(radioRojo, radioVerde, radioAzul, switchButton, spinnerEquipos, spinnerJugadores);
                    checkHabilitador.setText("Checkbox Habilitar ACTIVO!");
                } else {
                    permisoObj.deshabilitar(radioRojo, radioVerde, radioAzul, switchButton, spinnerEquipos, spinnerJugadores);
                    checkHabilitador.setText("Checkbox Habilitar INACTIVO!");
                    linearGeneral.setBackgroundColor(Color.WHITE);
                }
            }
        });


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                switch (checkedId) {
                    case R.id.radio1:
                        linearGeneral.setBackgroundColor(Color.RED);
                        break;
                    case R.id.radio2:
                        linearGeneral.setBackgroundColor(Color.GREEN);
                        break;

                    case R.id.radio3:
                        linearGeneral.setBackgroundColor(Color.BLUE);
                        break;

                }


            }
        });


        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "si", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();

                }

            }
        });


        ArrayAdapter adaptadorEquipos = ArrayAdapter.createFromResource(
                this, R.array.Equipos, android.R.layout.simple_spinner_item);
        adaptadorEquipos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEquipos.setAdapter(adaptadorEquipos);

        ArrayAdapter adaptadorJugadores = ArrayAdapter.createFromResource(
                this, R.array.jugadores_Real_Madrid, android.R.layout.simple_spinner_item);
        adaptadorJugadores.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJugadores.setAdapter(adaptadorJugadores);


        spinnerEquipos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {


                int opciones = R.array.jugadores_Real_Madrid;

                switch (arg2) {
                    case 0:
                        opciones = R.array.jugadores_Real_Madrid;
                        break;
                    case 1:
                        opciones = R.array.jugadores_Barcelona;
                        break;
                    case 2:
                        opciones = R.array.jugadores_Juventus;
                        break;
                }

                ArrayAdapter adaptador = ArrayAdapter.createFromResource(
                        MainActivity.this, opciones, android.R.layout.simple_spinner_item);
                adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerJugadores.setAdapter(adaptador);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });



        spinnerJugadores.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {

                Toast.makeText(getApplicationContext(), spinnerJugadores.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });



    }

    //<editor-fold desc="menu">
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
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


    //</editor-fold>
}


