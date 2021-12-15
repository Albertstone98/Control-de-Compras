package com.example.controldecompras;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.controldecompras.databinding.ActivityMainBinding;
import com.example.controldecompras.entidades.Producto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class nueva_compra extends Fragment {

    TextView fecha;
    EditText nameProducto, precioProducto, cantProducto;
    Button btnAgregar;
    ListView listView;
    ArrayList<Producto> listaProductos = new ArrayList<Producto>();

    public nueva_compra() {}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Capturo Controles
        CapturaControls(view);

        //Asigno fecha de hoy
        AsignoFecha();

        //Asigno Evento al Boton Agregar
        Agregar();
    }

    public void CapturaControls(View view){
        fecha = view.findViewById(R.id.tvFecha);
        nameProducto = view.findViewById(R.id.editTextProducto);
        precioProducto = view.findViewById(R.id.editTextPrecio);
        cantProducto = view.findViewById(R.id.editTextCantidad);
        listView = view.findViewById(R.id.listViewProductos);
        btnAgregar = view.findViewById(R.id.btnAgregar);
    }

    public void AsignoFecha(){
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        fecha.setText(formatter.format(new Date()));
    }

    public void Agregar(){
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nameProducto.getText().toString().equals("") || precioProducto.getText().toString().equals("") || cantProducto.getText().toString().equals("")){
                    Toast.makeText(getContext(), "Complete los espacios vacios", Toast.LENGTH_SHORT).show();
                    return;
                }
                llenarLista();
            }
        });
    }

    public void llenarLista(){
        int cantidad = Integer.parseInt(cantProducto.getText().toString());
        double precio = Double.parseDouble(precioProducto.getText().toString());
        double subtotal = cantidad * precio;

        Producto prod = new Producto();
        prod.setNombre(nameProducto.getText().toString());
        prod.setCant(cantidad);
        prod.setPrecio(precio);
        prod.setSubtotal(subtotal);

        listaProductos.add(prod);

        ArrayAdapter<Producto> adapter = new ArrayAdapter<Producto>(getActivity(), R.layout.item_list, listaProductos);
        listView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_nueva_compra, container, false);
    }
}