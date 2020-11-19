package isi.dam.practica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Button pasar_pantalla;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pasar_pantalla = (Button) findViewById(R.id.Pantalla2);

        Intent pasarPAntallla2 = new Intent(this,Pantalla2.class);
        pasar_pantalla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(pasarPAntallla2);
            }
        });


    }
}