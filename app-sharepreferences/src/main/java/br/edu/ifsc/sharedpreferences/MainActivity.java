package br.edu.ifsc.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final static String DEFAULT_VALUE="";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    EditText textEd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        textEd = findViewById(R.id.text_input);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(sharedPreferences.contains("text")){
            String text = sharedPreferences.getString("text",DEFAULT_VALUE);
            textEd.setText(text);
        }else{
            Toast.makeText(this,"Texto não encontrado", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    protected void onPause() {
        super.onPause();

        editor.putString("text",textEd.getText().toString());
        editor.commit();
        Toast.makeText(this,"Texto salvo", Toast.LENGTH_LONG).show();
    }
}
