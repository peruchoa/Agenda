package com.example.agenda.vistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import com.example.agenda.R;
import com.example.agenda.modelo.Conexion;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Define las variables de los controles del activity 'Agregar'.

    RecyclerView lista;
    FloatingActionButton btnAgregar;
    Conexion con;

    ArrayList<String> ids;
    ArrayList<String> nombres;
    ArrayList<String> telefonos;
    ArrayList<String> correos;
    ArrayList<String> direcciones;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vincular las variables con nuestros controles.

        lista = findViewById(R.id.lista);
        btnAgregar = findViewById(R.id.btnAgregar);

        // Habilitar el método 'click'.

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Abrir el segundo activity... 'Agregar'
                // param1: el activity donde se está actualmente.
                // param2: nombre de la clase del activity al que se quiere llamar.

                Intent intent = new Intent(MainActivity.this, Agregar.class);

                // Abrir segundo activity,
                // generar la base de datos
                // para pasar los datos a través del objeto 'Contacto'

                startActivity(intent);
            }
        });

        // Crear una conexion con nuestra conexion.

        con = new Conexion(this);

        ids = new ArrayList<String>();
        nombres = new ArrayList<String>();
        telefonos = new ArrayList<String>();
        correos = new ArrayList<String>();
        direcciones = new ArrayList<String>();

        // Llamar a nuestro método.
        prepararDatos();
        // Llamar a nuestro adaptador para poder asignarlo a nuestro RecyclerView.
        // ...entonces crear nuestro adaptador.

        Adaptador adaptador = new Adaptador(this,ids, nombres, telefonos, correos, direcciones);
        lista.setAdapter(adaptador);
        lista.setLayoutManager(new LinearLayoutManager(this));
    }

    // para organizar un poco nuestro código crear el método 'PrepararDatos'

    void prepararDatos(){

        Cursor cursor = con.consultar();

        // Validación: si tiene registros ir pasando de registro en registro.

        if (cursor.getCount()!=0) {

            while (cursor.moveToNext()) {

                ids.add("" + cursor.getInt(0));
                nombres.add(cursor.getString(1));
                telefonos.add(cursor.getString(2));
                correos.add(cursor.getString(3));
                direcciones.add(cursor.getString(4));

            }
        }
    }
}