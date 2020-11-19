package isi.dam.practica;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Pantalla2 extends AppCompatActivity {

    Toolbar toolbar;
    Button mandar_notifiacion;
    Context contexto = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mandar_notifiacion = (Button) findViewById(R.id.mandar_notifiacion);

        mandar_notifiacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Task1().execute("");
            }
        });

    }

    class Task1 extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            try{
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(String result) {

            Intent notificationIntent = new Intent(contexto, NotificacionPantalla2.class);
            contexto.sendBroadcast(notificationIntent);


        }
    }
}