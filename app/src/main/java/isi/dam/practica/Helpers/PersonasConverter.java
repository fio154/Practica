package isi.dam.practica.Helpers;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import isi.dam.practica.Modelo.Persona;

public class PersonasConverter {
    private static Gson gson = new Gson();

    @TypeConverter
    public static List<Persona> stringToPersonaList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Persona>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String someObjectListToString(List<Persona> someObjects) {
        return gson.toJson(someObjects);
    }
}