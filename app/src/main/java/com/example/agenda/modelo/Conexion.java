package com.example.agenda.modelo;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexion extends SQLiteOpenHelper {

    private Context context ;
    private static final String BD = "Agenda";
    private static final int version = 1;

    public Conexion(@Nullable Context context) {
        super(context, BD, null, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE contactos (id INT PRIMARY KEY, nombre TEXT, telefono TEXT, correo TEXT, direccion TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS contactos");
        onCreate(db);

    }

    public void agregar(Contacto contacto){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id",contacto.getId());
        values.put("nombre",contacto.getNombre());
        values.put("telefono",contacto.getTelefono());
        values.put("correo",contacto.getCorreo());
        values.put("direccion", contacto.getDireccion());

        db.insert("contactos", null, values);


    }
}
