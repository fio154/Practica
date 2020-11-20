package isi.dam.practica.Modelo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PersonaDAO {
    @Insert
    void insertar(Persona persona);

    @Delete
    void borrar(Persona persona);

    @Update
    void actualizar(Persona persona);

    @Query("SELECT * FROM persona WHERE id = :id LIMIT 1")
    Persona buscar(String id);

    @Query("SELECT * FROM persona")
    List<Persona> buscarTodos();

    @Query("DELETE FROM persona WHERE persona_column_id = :id ")
    int deleteById(long id);


}