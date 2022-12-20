package com.example.redessolidarias.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.redessolidarias.Entidades.Producto;
import com.example.redessolidarias.DB.DBFirebase;
import com.example.redessolidarias.Informacion;
import com.example.redessolidarias.Formulario;
import com.example.redessolidarias.Servicios;
import com.example.redessolidarias.R;
import java.util.ArrayList;

public class ProductoAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Producto> arrayProductos;

    public ProductoAdapter(Context context, ArrayList<Producto> arrayProductos) {
        this.context = context;
        this.arrayProductos = arrayProductos;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Producto> getArrayProductos() {
        return arrayProductos;
    }

    public void setArrayProductos(ArrayList<Producto> arrayProductos) {
        this.arrayProductos = arrayProductos;
    }

    @Override
    public int getCount() {
        return arrayProductos.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayProductos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        view = layoutInflater.inflate(R.layout.servicios_plantilla, null);
        Producto producto = arrayProductos.get(i);
        ImageView imgProducto = (ImageView) view.findViewById(R.id.imgProducto);
        TextView textNombreProducto = (TextView) view.findViewById(R.id.textNombreProducto);
        TextView textDescripcionProducto = (TextView) view.findViewById(R.id.textDescripcionProducto);
        TextView textPrecioProducto = (TextView) view.findViewById(R.id.textPrecioProducto);
        Button buttonAdd = (Button) view.findViewById(R.id.buttonAdd);
        Button buttonEdit = (Button) view.findViewById(R.id.buttonEdit);
        Button buttonDelete = (Button) view.findViewById(R.id.buttonDelete);

        textNombreProducto.setText(producto.getNombre());
        textDescripcionProducto.setText(producto.getDescripcion());
        textPrecioProducto.setText(String.valueOf(producto.getPrecio()));

        imgProducto.setImageResource(R.drawable.logoredes);

imgProducto.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context, Informacion.class);
        intent.putExtra("nombre", producto.getNombre());
        intent.putExtra("descripcion", producto.getDescripcion());
        intent.putExtra("precio", String.valueOf(producto.getPrecio()));
        context.startActivity(intent);
    }
});

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(context, Formulario.class);
                intent.putExtra("add", true);
                intent.putExtra("id", producto.getId());
                intent.putExtra("nombre", producto.getNombre());
                intent.putExtra("descripcion", producto.getDescripcion());
                intent.putExtra("precio", String.valueOf(producto.getPrecio()));
                intent.putExtra("imagen", producto.getImagen());
                intent.putExtra("latitud", producto.getLatitud());
                intent.putExtra("longitud", producto.getLongitud());
                context.startActivity(intent);

            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBFirebase dbFirebase = new DBFirebase();
                dbFirebase.deleteData(producto.getId());
                Intent intent = new Intent(context, Servicios.class);
                context.startActivity(intent);
            }
        });

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(context, Formulario.class);
                intent.putExtra("edit", true);
                intent.putExtra("id", producto.getId());
                intent.putExtra("nombre", producto.getNombre());
                intent.putExtra("descripcion", producto.getDescripcion());
                intent.putExtra("precio", String.valueOf(producto.getPrecio()));
                intent.putExtra("imagen", producto.getImagen());
                intent.putExtra("latitud", producto.getLatitud());
                intent.putExtra("longitud", producto.getLongitud());
                context.startActivity(intent);
            }
        });
        return view;
    }
}
