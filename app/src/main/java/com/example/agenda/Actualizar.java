package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Actualizar extends AppCompatActivity {

    EditText txtMid, txtMnombre, txtMtelefono, txtMcorreo, txtMdireccion;
    Button btnActualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);

        txtMid = findViewById(R.id.txtid2);
        txtMnombre = findViewById(R.id.txtNombre2);
        txtMtelefono = findViewById(R.id.txtTelefono2);
        txtMcorreo = findViewById(R.id.txtCorreo2);
        txtMdireccion = findViewById(R.id.txtDireccion2);

        btnActualizar = findViewById(R.id.btnActualizar);

        //Recibir estos valores que vienen de nuestro adaptador a traves de nuestro Intent.

        txtMid.setText(getIntent().getStringExtra("id"));
        txtMnombre.setText(getIntent().getStringExtra("nombre"));
        txtMtelefono.setText(getIntent().getStringExtra("telefono"));
        txtMcorreo.setText(getIntent().getStringExtra("correo"));
        txtMdireccion.setText(getIntent().getStringExtra("direccion"));

    }
}