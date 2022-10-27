package com.example.agenda.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.agenda.R;
import com.example.agenda.modelo.Conexion;
import com.example.agenda.modelo.Contacto;

// 1. Configurar nuestra interfase. Hacer referencia a mis controles.

public class Agregar extends AppCompatActivity {

    EditText txtid, txtNombre, txtTelefono, txtCorreo, txtDireccion;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        txtid = findViewById(R.id.txtid);
        txtNombre = findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtCorreo = findViewById(R.id.txtCorreo);
        txtDireccion = findViewById(R.id.txtDireccion);

        btnGuardar = findViewById(R.id.btnGuardar);

        // Generar nuestro boton de guardar al hacer click.

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Crear objeto de tipo conexion

                Conexion con = new Conexion(Agregar.this);

                // tambien crear una instancia de mi objeto 'Contacto'

                Contacto contacto = new Contacto();

                // Pasar los valores de las cajas de texto a nuestro objeto 'contacto'.
                // eliminar espacios al princiio y al final.

                contacto.setId(Integer.parseInt(txtid.getText().toString().trim()));    // convertir de entero a string.
                contacto.setNombre(txtNombre.getText().toString().trim());
                contacto.setTelefono(txtTelefono.getText().toString().trim());
                contacto.setCorreo(txtCorreo.getText().toString().trim());
                contacto.setDireccion(txtDireccion.getText().toString().trim());

                con.agregar(contacto);

                // Regresar del formulario 'agregar' al formulario principal.

                Intent intent = new Intent(Agregar.this, MainActivity.class);
                startActivity(intent);
            }
            // Como no está creada la parte del programa para ver los datos temporalmente se
            // va a usar la aplicacion DB Browser for SQLite.
            // Se baja de 'sqlitebrowser.org '

            // Desde Android Studio:
            // Seleccionar desde el menu: View - Tools Windows - Device file explorer
            // ir a la carpeta 'data' - buscar carpeta 'data' nuevamente
            // buscar la carpeta Agenda - databases, seleccionas los dos archivos
            // los guardas en el disco local
            // Desde el app: open.



        });



    }
}

