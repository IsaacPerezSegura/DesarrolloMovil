package com.isaacperezsegura.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Autor {
    private String apellidoP;
    private String apellidoM;
    private String nombre;
    private int pk_autor;
    private SQLiteDatabase base_datos;
    private DataBase admin;

    public Autor(String apellidoP, String apellidoM, String nombre, int pk_autor) {
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.nombre = nombre;
        this.pk_autor = pk_autor;
    }

    private void inicializar(Context contexto){
        admin = new DataBase(contexto, Config.db_name, null, Config.version);
        base_datos = admin.getWritableDatabase();
    }

    public boolean save(Context contexto){
        this.inicializar(contexto);
        ContentValues valores_objeto = new ContentValues();
        if(this.pk_autor == 0){
            valores_objeto.put("nombre",this.nombre);
            valores_objeto.put("apellidoP",this.apellidoP);
            valores_objeto.put("apellidoM",this.apellidoM);

            base_datos.insert("autor",null, valores_objeto);
            base_datos.close();
            return true;
        }else{
            valores_objeto.put("nombre", this.nombre);
            valores_objeto.put("apellidoP", this.apellidoP);
            valores_objeto.put("apellidoM", this.apellidoM);

            int actualizado = base_datos.update("autor", valores_objeto
                    ,"pk_autor="+ this.pk_autor, null);
            base_datos.close();
            if(actualizado == 1){
                return true;
            }
        }
        return false;
    }

    public void get(Context contexto, int pk_autor){
        this.inicializar(contexto);
        String query = "select * from autor where pk_autor="+pk_autor;

        Cursor registro = base_datos.rawQuery(query, null);
        if(registro.moveToFirst()){
            this.pk_autor = registro.getInt(0);
            this.nombre = registro.getString(1);
            this.apellidoP = registro.getString(2);
            this.apellidoM = registro.getString(3);
        }
        base_datos.close();
    }

    public ArrayList<Autor> get_all(Context contexto){
        this.inicializar(contexto);
        String query = "select * from autor";

        Cursor registro = base_datos.rawQuery(query, null);
        ArrayList<Autor> autores = new ArrayList();
        while(registro.moveToNext()){
            autores.add(
                    new Autor(registro.getString(2),
                    registro.getString(3)
                    ,registro.getString(1)
                    ,registro.getInt(0)));
        }
        base_datos.close();
        return autores;
    }

    public void delete(Context contexto){
        this.inicializar(contexto);
        int eliminado = base_datos.delete("autor"
                ,"pk_autor="+this.pk_autor
                ,null);
        base_datos.close();
        if(eliminado == 1){
            this.pk_autor = 0;
            this.nombre = "";
            this.apellidoP = "";
            this.apellidoM = "";
        }
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPk_autor() {
        return pk_autor;
    }

    public void setPk_autor(int pk_autor) {
        this.pk_autor = pk_autor;
    }
}
