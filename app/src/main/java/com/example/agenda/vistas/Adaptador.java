package com.example.agenda.vistas;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agenda.Actualizar;
import com.example.agenda.R;

import java.util.ArrayList;
public class Adaptador extends RecyclerView.Adapter<Adaptador.Vista> {
    private Context context;
    private ArrayList<String> ids;
    private ArrayList<String> nombres;
    private ArrayList<String> telefonos;
    private ArrayList<String> correos;
    private ArrayList<String> direcciones;
    ConstraintLayout fila;

    public Adaptador(Context context, ArrayList<String> ids, ArrayList<String> nombres, ArrayList<String> telefonos, ArrayList<String> correos, ArrayList<String> direcciones) {
        this.context = context;
        this.ids = ids;
        this.nombres = nombres;
        this.telefonos = telefonos;
        this.correos = correos;
        this.direcciones = direcciones;
    }
    @NonNull
    @Override
    public Adaptador.Vista onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(context);
        View v = inflate.inflate(R.layout.elemento, parent, false);
        return new Vista(v);
    }
    @Override
    public void onBindViewHolder(@NonNull Adaptador.Vista holder, int position) {
        holder.txtShowNombre.setText(nombres.get(position));
        holder.txtShowTelefono.setText(telefonos.get(position));

        fila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Cuando de click en el elemento que me envie hacia el formulario de actualizar.

                //Cuando pida un 'context' se toma del metodo constructor.
                // Luego poner el formulario a donde se desea ir.

                Intent intent = new Intent(context, Actualizar.class);

                intent.putExtra("id", ids.get(position));
                intent.putExtra("nombre", nombres.get(position));
                intent.putExtra("telefono", telefonos.get(position));
                intent.putExtra("correo",  correos.get(position));
                intent.putExtra("direccion", direcciones.get(position));

                context.startActivity(intent);
            }
        }) ;
    }
    @Override
    public int getItemCount() {
        return nombres.size();
    }

    public class Vista extends RecyclerView.ViewHolder {
        TextView txtShowNombre, txtShowTelefono ;
        // Hacer referencia a mis objetos.
        public Vista(@NonNull View itemView) {
            super(itemView);
            txtShowNombre = itemView.findViewById(R.id.txtShowNombre);
            txtShowTelefono = itemView.findViewById(R.id.txtShowTelefono);

            fila = itemView.findViewById(R.id.lista);
            //fila = itemView.findViewById(R.id.fila);
        }
    }
}
