package com.example.logonrm.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView actPaises;
    Spinner spnPaises;
    String[]paises = {
            "Alemanha",
            "Belize",
            "Camarões",
            "Dinamarca",
            "Espanha",
            "Finlandia"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actPaises = findViewById(R.id.actPaises);

        ArrayAdapter<String> adapterParaAutoComplete = new ArrayAdapter<String>(
             this,
                android.R.layout.simple_list_item_1,
                paises
        );

        spnPaises = findViewById(R.id.spnPaises);


        spnPaises.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String pais = paises[position];
                Toast.makeText(MainActivity.this, "Voce Selecionou" + pais, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //tem 3 parametros
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                paises
                );

        spnPaises.setAdapter(adapter);
        actPaises.setAdapter(adapterParaAutoComplete);


    }

    public void salvar(View view) {
        String pais = spnPaises.getSelectedItem().toString();
        Toast.makeText(this, "Você selecionou" + pais, Toast.LENGTH_SHORT).show();
    }
}
