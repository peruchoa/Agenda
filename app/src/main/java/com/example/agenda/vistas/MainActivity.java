package com.example.agenda.vistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.agenda.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    //Define las variables de los controles del activity 'Agregar'.

    RecyclerView lista;
    FloatingActionButton btnAgregar;


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
    }
}