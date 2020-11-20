package isi.dam.practica.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.Executor;

import isi.dam.practica.Modelo.Persona;
import isi.dam.practica.Modelo.PersonaDAO;

//aca pongo todas las clases
@Database(entities = {Persona.class}, version = 1)
public abstract class PracticaDatabase extends RoomDatabase {
    public static Executor databaseWriteExecutor;

    @SuppressWarnings("WeakerAccess")
    public abstract PersonaDAO PersonaDAO();

    static PracticaDatabase getInstance(final Context context) {
        return Room.databaseBuilder(context, PracticaDatabase.class, "database-name").build();
    }
}