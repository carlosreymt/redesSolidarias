package com.example.redessolidarias;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import androidx.annotation.NonNull;
import com.example.redessolidarias.Adaptadores.ProductoAdapter;
import com.example.redessolidarias.DB.DBFirebase;
import com.example.redessolidarias.Entidades.Producto;
import java.util.ArrayList;

public class Servicios extends AppCompatActivity {

    private ListView listViewProductos;
    private ArrayList<Producto> arrayProductos;
    private ProductoAdapter productoAdapter;
    private DBFirebase dbFirebase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);

        listViewProductos = (ListView) findViewById(R.id.listViewProductos);
        arrayProductos = new ArrayList<>();
        dbFirebase = new DBFirebase();

/*
        // Listado de Productos inicial Informacion utilizada en Sprint 1 y 2

        Producto producto1= new Producto ("Derechos de Peticion","Acciones y Derechos Personales y Colectivos",10000,"","","");
        Producto producto2= new Producto ("Acciones Constitucionales","Servicios de apoyo constitucional",20000,"","","");
        Producto producto3= new Producto ("Asesoría Legal","Guía y Orientación para el ejercicio de los derechos",30000,"","","");
        Producto producto4= new Producto ("Contratos","Elaboración de Contratos a su medida",40000,"","","");

        arrayProductos.add(producto1);
        arrayProductos.add(producto2);
        arrayProductos.add(producto3);
        arrayProductos.add(producto4);
*/
        productoAdapter = new ProductoAdapter(this, arrayProductos);
        listViewProductos.setAdapter(productoAdapter);
        dbFirebase.getData(productoAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.adicionar:
                intent = new Intent(getApplicationContext(), Formulario.class);
                startActivity(intent);
                return true;
            case R.id.ubicacion:
                intent = new Intent(getApplicationContext(), ubicacion.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}