package isi.dam.practica.Modelo;
import android.os.Parcel;
import android.os.Parcelable;

public class OtraPersona implements Parcelable {

    private String nombre;
    private String apellido;
    private Integer edad;

    public OtraPersona(){
    }

    public OtraPersona(String nombre, String apellido, Integer edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    protected OtraPersona(Parcel in) {
        this.nombre = in.readString();
        this.apellido = in.readString();
        if (in.readByte() == 0) {
            edad = null;
        } else {
            edad = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeString(this.apellido);
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