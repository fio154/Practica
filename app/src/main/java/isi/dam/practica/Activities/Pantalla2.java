package isi.dam.practica.Activities;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import isi.dam.practica.Notifiaciones.NotificacionPantalla2;
import isi.dam.practica.R;

public class Pantalla2 extends AppCompatActivity {

    Toolbar toolbar;
    Button mandar_notifiacion, button, button2, button3;
    Context contexto = this;
    ProgressBar progressBar;
    TextView nombre_op;

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

        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=1; i<=10; i++){
                    UnSegundo();
                }
                Toast.makeText(getBaseContext(), "Tarea Larga Finalizada", Toast.LENGTH_LONG).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Hilos();

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EjemploAsyncTask ejemploAsyncTask = new EjemploAsyncTask();
                ejemploAsyncTask.execute("hola");

            }
        });

        /*OtraPersona op = getIntent().getParcelableExtra("op");
        System.out.println(op.getNombre());

        nombre_op = (TextView) findViewById(R.id.nombre_otraPersona);
        nombre_op.setText(op.getNombre());*/

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

    private void UnSegundo(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){}
    }

    void Hilos(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1; i<=10; i++){
                    UnSegundo();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getBaseContext(), "Tarea Larga Finalizada", Toast.LENGTH_LONG).show();
                    }
                });

            }
        }).start();
    }

    private class EjemploAsyncTask extends AsyncTask<String,Integer,Boolean>{

        @Override
        protected Boolean doInBackground(String... strings) {

            for(int i=1; i<=10; i++){
                UnSegundo();

                publishProgress(i*10);
                if(isCancelled()){
                    break;
                }
            }
            return true;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setMax(100);
            progressBar.setProgress(0);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            progressBar.setProgress(values[0].intValue());
        }

        @Override
        protected void onPostExecute(Boolean resultado) {
            //super.onPostExecute(aVoid);
            if(resultado){
                Toast.makeText(getBaseContext(), "Tarea Larga Finalizada en AsyncTask", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();

            Toast.makeText(getBaseContext(), "Tarea Larga Ha sido cancelada", Toast.LENGTH_LONG).show();
        }
    }


}