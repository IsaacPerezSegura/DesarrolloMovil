package com.isaacperezsegura.empleados.Modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;

public class MySQLiteOpenHelper extends SQLiteOpenHelper{

    public MySQLiteOpenHelper(Context context,String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table empleado(id INTEGER primary key AUTOINCREMENT, nombre text" +
                ", apellidoP text, apellidoM text, telefono text, edad text, correo text, calleN text" +
                ", colonia text, ciudad text, estado text, estadoCivil text" +
                ",nacionalidad text,photo text" +
                ",nomina text,puesto txt,rfc txt,curp txt, nss txt,escolaridad txt)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS empleado");
        db.execSQL("create table empleado(id INTEGER primary key AUTOINCREMENT, nombre text" +
                ", apellidoP text, apellidoM text, telefono text, edad text, correo text, calleN text" +
                ", colonia text, ciudad text, estado text, estadoCivil text" +
                ",nacionalidad text,photo text" +
                ",nomina text,puesto txt,rfc txt,curp txt, nss txt,escolaridad txt)");
    }
}
