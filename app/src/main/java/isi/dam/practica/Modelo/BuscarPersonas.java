package isi.dam.practica.Modelo;


import android.os.AsyncTask;

import java.util.List;

// android.os.AsyncTask<Params, Progress, Result>
public class BuscarPersonas extends AsyncTask<String, Void, List<Persona>> {

    private PersonaDAO dao;
    private OnPersonaResultCallback callback;

    public BuscarPersonas(PersonaDAO dao, OnPersonaResultCallback context) {
        this.dao = dao;
        this.callback = context;
    }

    @Override
    protected List<Persona> doInBackground(String... strings) {
        List<Persona> personas = dao.buscarTodos();
        return personas;
    }

    @Override
    protected void onPostExecute(List<Persona> personas) {
        super.onPostExecute(personas);
        callback.onResult(personas);
    }
}