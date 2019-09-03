package br.edu.ifsc.sharedpreferences;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Notas {
    Context context;

    final static String DEFAULT_VALUE="";

    SQLiteDatabase db;
    public static final String SQLDATABASE= "database";

    public Notas(Context context){
        this.context=context;
        db = context.openOrCreateDatabase(SQLDATABASE, context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE notas (id INTEGER primary key AUTOINCREMENT, nota varchar)");
    }
    public boolean salvar(String texto){
        return true;
    }
    public String recuperar(){
        return DEFAULT_VALUE;
    }
}
