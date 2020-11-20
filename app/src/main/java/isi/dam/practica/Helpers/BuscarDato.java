package isi.dam.practica.Helpers;

import android.os.AsyncTask;

import java.util.List;

import isi.dam.practica.Database.Repositorio;
import isi.dam.practica.Modelo.Dato;
import isi.dam.practica.Modelo.DatoDAO;

class BuscarDato extends AsyncTask<String, Void, List<Dato>> {

    private DatoDAO dao;
    private Repositorio callback;

    public BuscarDato(DatoDAO dao, Repositorio context) {
        this.dao = dao;
        this.callback = context;
    };

    @Override
    protected List<Dato> doInBackground(String... strings) {
        List<Dato> datos = dao.buscarTodos();
        return datos;
    };

    @Override
    protected void onPostExecute(List<Dato> datos) {
        super.onPostExecute(datos);
        callback.onResult(datos);
    };
};