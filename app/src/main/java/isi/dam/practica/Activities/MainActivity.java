package isi.dam.practica.Activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

import isi.dam.practica.Database.PersonaRepository;
import isi.dam.practica.Modelo.OnPersonaResultCallback;
import isi.dam.practica.Modelo.OtraPersona;
import isi.dam.practica.Modelo.Persona;
import isi.dam.practica.R;

public class MainActivity extends AppCompatActivity implements OnPersonaResultCallback {

    Button pasar_pantalla, btn_implicito;
    Toolbar toolbar;
    PersonaRepository repository;
    TextView count;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pasar_pantalla = (Button) findViewById(R.id.Pantalla2);

        OtraPersona op = new OtraPersona("fiorella", "triverio", 21);

        Intent pasarPAntallla2 = new Intent(context, Pantalla2.class);

        pasarPAntallla2.putExtra("op", op);

        pasar_pantalla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(pasarPAntallla2);
            }
        });

        btn_implicito = (Button) findViewById(R.id.btn_intent_implicito);

        btn_implicito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("tel:3483400662")));
            }
        });

        //BD
        /*repository = new PersonaRepository(this.getApplication(), this);
        Persona persona = new Persona("fiorella", "triverio", 21);
        repository.insertar(persona);

        System.out.println("holaaa   " + repository.count());*/

    }

    @Override
    public void onResult(List<Persona> persona) {
        System.out.println("EXITOOOOOOO");
    }
}