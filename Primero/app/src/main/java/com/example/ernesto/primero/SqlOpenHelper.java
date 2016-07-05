package com.example.ernesto.primero;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ernesto.primero.ScanActivity;


public class SqlOpenHelper extends SQLiteOpenHelper {

    private static final String BD_NAME = "Scanner.db";
    private static final int SCHEME_VERSION = 1;
    private SQLiteDatabase db;


    public SqlOpenHelper(Context context) {
        super(context, BD_NAME, null, SCHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Carrito (id_prod INTEGER PRIMARY KEY AUTOINCREMENT, cod_barra TEXT)");
    }
    //agregar la tabla Productos mediante algun import de un archivo externo  ((agregar detalle TEXT en el producto))


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
