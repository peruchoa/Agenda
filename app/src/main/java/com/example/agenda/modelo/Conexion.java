package com.example.agenda.modelo;

import android.content.ContentValues;
import android.content.Context;
// Crear el constructor.
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

// Heredar de la clase que se llama SQLiteOpenHelper.
// Al seleccionar SQLiteOpenHelper se genera el código del punto 2.

public class Conexion extends SQLiteOpenHelper {

    private Context context ;
    private static final String BD = "Agenda";
    private static final int version = 1;

    // Punto 2
    // Tomar el primer parámetro, los demás se pueden eliminar.

    public Conexion(@Nullable Context context) {
        super(context, BD, null, version);
        this.context = context;
    }

    // Conexion para crear mi base de datos 'Agenda'

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Crear una variable de tipo 'string' que se va a llamar 'query'
        // y crear las tablas que se van a necesitar y sus campos.

         String query = "CREATE TABLE contactos (id INT PRIMARY KEY, nombre TEXT, telefono TEXT, correo TEXT, direccion TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Este método es para el caso que se cambien la version de la base de datos.

        db.execSQL("DROP TABLE IF EXISTS contactos");
        onCreate(db);   // Generar nueva estructura en caso de haber sido modificada.

    }

        // Crear los métodos para poder agregar los datos.
        // Se crea un objeto con la clase 'Contacto'

    public void agregar(Contacto contacto){

        // Abrir una conexion a mi base de datos pero en modo lectura-escritura.

        SQLiteDatabase db = this.getWritableDatabase();

        // Definir los valores que se desean guardar en la tabla
        // que se encuentra en el formulario de agregar.

        ContentValues values = new ContentValues();
        values.put("id",contacto.getId());
        values.put("nombre",contacto.getNombre());
        values.put("telefono",contacto.getTelefono());
        values.put("correo",contacto.getCorreo());
        values.put("direccion", contacto.getDireccion());

        db.insert("contactos", null, values);


    }

    // Generar nuestro método 'consultar'.

    public Cursor consultar(){

        // Traer todos los registros que se encuentren en la tabla.

        String query = "Select * from contactos";
        SQLiteDatabase db = this.getReadableDatabase(); // leer datos solamente.

        // Crear un objeto cursor.

        Cursor cursor = null;

        // Validando si hay registros.

        if(cursor == null) {
            cursor = db.rawQuery(query, null);
        }

        // Pase a MainActivity.

        return cursor;


    }

}
