package com.example.redessolidarias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Informacion extends AppCompatActivity {
private Button btnRegresoInformacion;
private TextView textNombreInformacion;
private TextView textDescripcionInformacion;
private TextView textPrecioInformacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        btnRegresoInformacion = (Button) findViewById(R.id.btnRegresoInformacion);
        textDescripcionInformacion = (TextView) findViewById(R.id.textDescripcionInformacion);
        textNombreInformacion = (TextView) findViewById(R.id.textNombreInformacion);
        textPrecioInformacion = (TextView) findViewById(R.id.textPrecioInformacion);

        Intent intentIn = getIntent();
        textNombreInformacion.setText(intentIn.getStringExtra("nombre"));
        textDescripcionInformacion.setText(intentIn.getStringExtra("descripcion"));
        textPrecioInformacion.setText(intentIn.getStringExtra("precio"));

        btnRegresoInformacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Servicios.class);
                startActivity(intent);

            }
        });
    }
}