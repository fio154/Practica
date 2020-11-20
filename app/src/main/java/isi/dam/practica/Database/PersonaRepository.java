package isi.dam.practica.Database;

import android.app.Application;

import isi.dam.practica.Modelo.Persona;
import isi.dam.practica.Modelo.PersonaDAO;

public class PersonaRepository {
    private PersonaDAO personaDAO;

    public PersonaRepository (Application application){
        PracticaDatabase db = PracticaDatabase.getInstance(application);
        personaDAO = db.PersonaDAO();
    }

    public void insertar(final Persona persona){
        PracticaDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                personaDAO.insertar(persona);
            }
        });
    };



}