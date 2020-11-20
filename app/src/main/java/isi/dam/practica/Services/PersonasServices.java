package isi.dam.practica.Services;

import java.util.List;

import isi.dam.practica.Modelo.Persona;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface PersonasServices {
    @GET("persona/{id}")
    Call<Persona> getDish(@Path("id") String id);

    @GET("persona")
    Call<List<Persona>> getPersonaList();

    @POST("persona")
    Call<Persona> createDish(@Body Persona persona);
}