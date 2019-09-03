package br.edu.ifsc.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText textEd;
    Notas notas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textEd = findViewById(R.id.text_input);
        notas = new Notas(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        textEd.setText(notas.recuperar());
    }


    @Override
    protected void onPause() {
        super.onPause();
        boolean salvarTexto =notas.salvar(textEd.getText().toString());
        if(salvarTexto) {
            Toast.makeText(this, "Texto salvo", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Texto NÃO foi salvo com sucesso!", Toast.LENGTH_LONG).show();
        }
    }
}
