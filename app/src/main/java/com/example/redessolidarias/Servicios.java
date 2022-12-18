package com.example.redessolidarias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.redessolidarias.Adaptadores.ProductoAdapter;
import com.example.redessolidarias.Entidades.Producto;

import java.util.ArrayList;

public class Servicios extends AppCompatActivity {

    private ListView listViewProductos;
    private ArrayList<Producto> arrayProductos;
    private ProductoAdapter productoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);

        listViewProductos = (ListView) findViewById(R.id.listViewProductos);
        arrayProductos = new ArrayList<>();

        // Listado de Productos inicial

        Producto producto1= new Producto ("Derechos de Peticion","Acciones y Derechos Personales y Colectivos",10000,"","","");
        Producto producto2= new Producto ("Acciones Constitucionales","Servicios de apoyo constitucional",20000,"","","");
        Producto producto3= new Producto ("Asesoría Legal","Guía y Orientación para el ejercicio de los derechos",30000,"","","");
        Producto producto4= new Producto ("Contratos","Elaboración de Contratos a su medida",40000,"","","");

        arrayProductos.add(producto1);
        arrayProductos.add(producto2);
        arrayProductos.add(producto3);
        arrayProductos.add(producto4);

        productoAdapter = new ProductoAdapter(this, arrayProductos);
        listViewProductos.setAdapter(productoAdapter);

    }
}