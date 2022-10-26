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

        btnGuardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Conexion con = new Conexion(Agregar.this);
                    Contacto contacto = new Contacto();

                    contacto.setId(Integer.parseInt(txtid.getText().toString().trim()));
                    contacto.setNombre(txtNombre.getText().toString().trim());
                    contacto.setTelefono(txtTelefono.getText().toString().trim());
                    contacto.setCorreo(txtCorreo.getText().toString().trim());
                    contacto.setDireccion(txtDireccion.getText().toString().trim());

                    con.agregar(contacto);

                    Intent intent = new Intent(Agregar.this, MainActivity.class);
                    startActivity(intent@);
                }

        });



    }
}