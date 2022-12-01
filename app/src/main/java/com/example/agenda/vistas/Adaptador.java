package com.example.agenda.vistas;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agenda.R;

import java.util.ArrayList;
public class Adaptador extends RecyclerView.Adapter<Adaptador.Vista> {
    private Context context;
    private ArrayList<String> ids;
    private ArrayList<String> nombres;
    private ArrayList<String> telefonos;
    private ArrayList<String> correos;
    private ArrayList<String> direcciones;

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
    }
    @Override
    public int getItemCount() {
        return nombres.size();
    }
    public class Vista extends RecyclerView.ViewHolder {
        TextView txtShowNombre, txtShowTelefono ;
        ConstraintLayout fila;

        // Hacer referencia a mis objetos.
        public Vista(@NonNull View itemView) {
            super(itemView);
            txtShowNombre = itemView.findViewById(R.id.txtShowNombre);
            txtShowTelefono = itemView.findViewById(R.id.txtShowTelefono);
            fila = itemView.findViewById(R.id.lista);
        }
    }
}
