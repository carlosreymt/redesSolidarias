package com.example.redessolidarias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.redessolidarias.DB.DBFirebase;
import com.example.redessolidarias.Entidades.Producto;

public class Formulario extends AppCompatActivity {
    private Button btnFormulario;
    private EditText editTextNombreFormulario;
    private EditText editTextDescripcionFormulario;
    private EditText editTextPrecioFormulario;
    private DBFirebase dbFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario2);

       btnFormulario = (Button) findViewById(R.id.btnFormulario);
       editTextNombreFormulario = (EditText) findViewById(R.id.editTextNombreFormulario);
       editTextDescripcionFormulario = (EditText) findViewById(R.id.editTextDescripcionFormulario);
       editTextPrecioFormulario = (EditText) findViewById(R.id.editTextPrecioFormulario);
       dbFirebase = new DBFirebase();
       Intent intentIN = getIntent();
        if(intentIN.getBooleanExtra("edit",false)){
            editTextNombreFormulario.setText(intentIN.getStringExtra("nombre"));
            editTextDescripcionFormulario.setText(intentIN.getStringExtra("descripcion"));
            editTextPrecioFormulario.setText(intentIN.getStringExtra("precio"));
        }

       btnFormulario.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Producto producto = new Producto (
                    editTextNombreFormulario.getText().toString(),
                    editTextDescripcionFormulario.getText().toString(),
                      Integer.parseInt(editTextPrecioFormulario.getText().toString()),
                      "",
                      "",
                      ""
               );
               dbFirebase.insertData(producto);
               if(intentIN.getBooleanExtra("edit",false)){
                   producto.setId(intentIN.getStringExtra("id"));
                   dbFirebase.updateData(producto);
               }else{
                   dbFirebase.insertData(producto);
               }
               Intent intent = new Intent(getApplicationContext(), Servicios.class);
               startActivity(intent);
           }
       });
    }
}