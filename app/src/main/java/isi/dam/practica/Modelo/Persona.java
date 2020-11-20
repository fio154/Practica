package isi.dam.practica.Modelo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Persona.TABLE_NAME)
public class Persona implements Parcelable {

    public static final String TABLE_NAME = "persona";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ID = "persona_column_id";

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = COLUMN_ID)
    private Long id;

    @ColumnInfo(name = "nombre")
    private String nombre = "";

    @ColumnInfo(name = "apellido")
    private String apellido = "";

    @ColumnInfo(name = "edad")
    private Integer edad = 0;

    public Persona(){
    }

    public Persona(String nombre, String apellido, Integer edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    protected Persona(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        nombre = in.readString();
        apellido = in.readString();
        if (in.readByte() == 0) {
            edad = null;
        } else {
            edad = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        dest.writeString(nombre);
        dest.writeString(apellido);
        if (edad == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(edad);
        }
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    public static final Creator<Persona> CREATOR = new Creator<Persona>() {
        @Override
        public Persona createFromParcel(Parcel in) {
            return new Persona(in);
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getEdad() {
        return edad;
    }

}
