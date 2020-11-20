package isi.dam.practica.Database;

import android.app.Application;
import android.util.Log;

import java.util.List;

import isi.dam.practica.Activities.MainActivity;
import isi.dam.practica.Modelo.BuscarPersonas;
import isi.dam.practica.Modelo.OnPersonaResultCallback;
import isi.dam.practica.Modelo.Persona;
import isi.dam.practica.Modelo.PersonaDAO;

public class PersonaRepository implements OnPersonaResultCallback {
    private PersonaDAO personaDAO;
    private OnResultCallback callback;

    public PersonaRepository(Application application, MainActivity mainActivity){
        PracticaDatabase db = PracticaDatabase.getInstance(application);
        personaDAO = db.PersonaDAO();
    }

    public void insertar(final Persona persona){
        PracticaDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                personaDAO.insertar(persona);
                System.out.println("insertando");
            }
        });
    }

   /* public void insertar(Persona persona) {
        personaDAO.insertar(persona);
    }*/

    public List<Persona> getAllPersons() {
        return personaDAO.getAll();
    }

    public void buscarTodos() {
        new BuscarPersonas(personaDAO, (OnPersonaResultCallback) this).execute();
    }

    public int count() {
        final int[] resul = {-1};
        PracticaDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                resul[0] =  personaDAO.count();
            }
        });
      return resul[0];
    }


    @Override
    public void onResult(List<Persona> persona) {
        Log.d("DEBUG", "Plato found");
        callback.onResult(persona);
    }

    public interface OnResultCallback<T> {
        void onResult(List<T> result);
    }
}