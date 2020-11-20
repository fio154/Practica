package isi.dam.practica.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import isi.dam.practica.R;

public class MainActivity extends AppCompatActivity {

    Button pasar_pantalla, btn_implicito;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pasar_pantalla = (Button) findViewById(R.id.Pantalla2);

        Intent pasarPAntallla2 = new Intent(this, Pantalla2.class);
        pasar_pantalla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(pasarPAntallla2);
            }
        });

        btn_implicito = (Button) findViewById(R.id.btn_intent_implicito);

        btn_implicito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("tel:3483400662")));
            }
        });

       /* PracticaDatabase db = new PracticaDatabase() {
            @Override
            public PersonaDAO PersonaDAO() {
                return null;
            }

            @NonNull
            @Override
            protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
                return null;
            }

            @NonNull
            @Override
            protected InvalidationTracker createInvalidationTracker() {
                return null;
            }

            @Override
            public void clearAllTables() {

            }
        };

        PersonaRepository repo = new PersonaRepository(this.getApplication());

        //Persona persona = new Persona("fiorella", "triverio", 21);
        //repo.insertar(persona);

        List<Persona> personas = repo.getAllPersons();
        for(Persona i : personas) {
            System.out.println(i.getNombre() + " " + i.getApellido()+ " " + i.getEdad());
        }*/



    }
}