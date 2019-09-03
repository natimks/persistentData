package br.edu.ifsc.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class Notas {
    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedEditor;
    final static String DEFAULT_VALUE="";

    public Notas(Context context){
        this.context=context;
        sharedPreferences =context.getSharedPreferences("data",context.MODE_PRIVATE);
        sharedEditor = sharedPreferences.edit();
    }
    public boolean salvar(String texto){
        sharedEditor.putString("text",texto);
        return sharedEditor.commit();
    }
    public String recuperar(){
        if(sharedPreferences.contains("text")){
            String text = sharedPreferences.getString("text",DEFAULT_VALUE);
            return  text;
        }
        return DEFAULT_VALUE;
    }
}
