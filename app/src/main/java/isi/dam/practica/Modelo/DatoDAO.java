package isi.dam.practica.Modelo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DatoDAO {
    @Insert
    void insertar(Dato dato);

    @Delete
    void borrar(Dato dato);

    @Update
    void actualizar(Dato dato);

    @Query("SELECT * FROM dato WHERE id = :id LIMIT 1")
    Dato buscar(String id);

    @Query("SELECT * FROM dato")
    List<Dato> buscarTodos();
}