package isi.dam.practica.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import isi.dam.practica.Modelo.Persona;
import isi.dam.practica.Modelo.PersonaDAO;

//aca pongo todas las clases
@Database(entities = {Persona.class}, version = 1)
public abstract class PracticaDatabase extends RoomDatabase {
    /*public static Executor databaseWriteExecutor;

    public abstract PersonaDAO PersonaDAO();

    public static PracticaDatabase getInstance(final Context context) {
        return Room.databaseBuilder(context, PracticaDatabase.class, "database-name").build();
    }*/

    public abstract PersonaDAO PersonaDAO();

    private static volatile PracticaDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 1;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static PracticaDatabase  getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (PracticaDatabase .class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PracticaDatabase .class, "database-name")
                            .build();
                }
            }
        }
        System.out.println("abriendo bd -------------------- TDRJHGVJHBKJIUYFCFJDXCGFBHJKMLJHUYGTY");
        return INSTANCE;
    }

}