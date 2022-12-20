package com.example.redessolidarias.DB;

import android.support.annotation.NonNull;
import com.example.redessolidarias.Adaptadores.ProductoAdapter;
import com.example.redessolidarias.Entidades.Producto;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class DBFirebase {
private FirebaseFirestore db;

public DBFirebase () {
    db = FirebaseFirestore.getInstance();
}

public void insertData (Producto producto) {
    // Create a new user with a first and last name
    Map<String, Object> prod = new HashMap<>();
    prod.put("id", producto.getId());
    prod.put("nombre", producto.getNombre());
    prod.put("descripcion", producto.getDescripcion());
    prod.put("precio", producto.getPrecio());
    prod.put("imagen", producto.getImagen());
    prod.put("latitud", producto.getLatitud() );
    prod.put("longitud", producto.getLongitud());


// Add a new document with a generated ID
    db.collection("productos").add(prod);
                }

       public void getData(ProductoAdapter productoAdapter){

    db.collection("productos").get()
                   .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                       @Override
                       public void onComplete(@NonNull Task<QuerySnapshot> task) {
                           if (task.isSuccessful()) {
                               ArrayList<Producto> listaTemporal = new ArrayList<>();

                               for (QueryDocumentSnapshot document : task.getResult()) {
                                   Producto producto = new Producto(
                                           document.getData().get("id").toString(),
                                           document.getData().get("nombre").toString(),
                                           document.getData().get("descripcion").toString(),
                                           Integer.parseInt(document.getData().get("precio").toString()),
                                           document.getData().get("imagen").toString(),
                                           document.getData().get("latitud").toString(),
                                           document.getData().get("longitud").toString()
                                   );
                                   listaTemporal.add(producto);
                               }
                               productoAdapter.setArrayProductos(listaTemporal);
                               productoAdapter.notifyDataSetChanged();
                           }
                       }
                   });
       }

       public void deleteData (String id) {
           db.collection("productos").whereEqualTo("id", id)
                   .get()
                   .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                       @Override
                       public void onComplete(@NonNull Task<QuerySnapshot> task) {
                           if (task.isSuccessful()) {
                               ArrayList<Producto> listaTemporal = new ArrayList<>();
                               for (QueryDocumentSnapshot document : task.getResult()) {
                                   document.getReference().delete();
                               }
                           }
                       }
                   });
       }

    public void updateData (Producto producto) {
        db.collection("productos").whereEqualTo("id", producto.getId())
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<Producto> listaTemporal = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                document.getReference().update(
                                        "nombre", producto.getNombre(),
                                        "descripcion", producto.getDescripcion(),
                                        "precio", producto.getPrecio(),
                                        "imagen", producto.getImagen(),
                                        "latitud", producto.getLatitud(),
                                        "longitud", producto.getLongitud()
                                );
                            }
                        }
                    }
                });

    }
    }
