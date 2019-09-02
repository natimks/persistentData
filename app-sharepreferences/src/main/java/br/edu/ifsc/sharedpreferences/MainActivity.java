package br.edu.ifsc.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

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
    protected void onStart() {
        super.onStart();
        String text = sharedPreferences.getString("text",DEFAULT_VALUE);
        textEd.setText(text);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String text = sharedPreferences.getString("text",DEFAULT_VALUE);
        textEd.setText(text);
    }


    @Override
    protected void onPause() {
        super.onPause();

        editor.putString("text",textEd.getText().toString());
        editor.commit();
    }

    @Override
    protected void onStop() {
        super.onStop();

        editor.putString("text",textEd.getText().toString());
        editor.commit();
    }
}
