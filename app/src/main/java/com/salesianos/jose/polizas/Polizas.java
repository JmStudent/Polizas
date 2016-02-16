package com.salesianos.jose.polizas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class Polizas extends AppCompatActivity {

    //Vistas
    private EditText mEdad = null;
    private TextView mImporte = null;
    private Switch mEstado = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polizas);
        mEdad = (EditText) findViewById(R.id.insertaedad);
        mImporte = (TextView) findViewById(R.id.cajatexto);
        mEstado = (Switch) findViewById(R.id.estado);

    }

    public void showText(View v) {
        float importe = 40f;
        String edadCadena = mEdad.getText().toString();
        if(TextUtils.isEmpty(edadCadena)) {
            mEdad.setError("Este campo no puede quedar vacío");
            return;
        }
        int edad = Integer.parseInt(edadCadena);
        int incremento = 0;
        if (edad > 34) {
            for (int i = 34; i < edad; i++)
                incremento++;
        }
        mImporte.setText("El importe de su póliza es " + (importe + incremento) + " € / mes ");
    }

    public void hideText(View v) {
        mImporte.setText("");
    }
}
