package com.isaacperezsegura.sqliteexample;

public class Config {
    public static final String db_name = "Ejemplo";
    public static final int version = 1;
    public static final String [] script_db ={
            "CREATE TABLE autor(pk_autor INTEGER PRIMARY KEY AUTOINCREMENT" +
                    ", nombre varchar (100) not null, apellidoP varchar(100) not null" +
                    ", apellidoM varchar(100) not null," +
                    "FOREIGN KEY(pk_autor) REFERENCES autor(pk_autor));"
    };

}
