package com.example.sendmessageviewbinding.model.data;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Objects;

/**
 * Clase Person que engloba la información de una persona
 *
 * @author: David Zambrana Romero
 * @version: 1.0
 */
public class Person implements Parcelable, Serializable {
    public static final String KEY = "Person";
    private String name;
    private String surname;
    private String dni;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o; //DownCasting, no dará error porque ya he comprobado las clases
        // person hereda de object, por tanto convertirlo en Person
        return Objects.equals(dni, person.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    //region el toString siempre se debe implementar.
    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dni='" + dni + '\'' ;

    }

    //region Método GET y SET de la clase
    public Person(String name, String surname, String dni) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    //endregion
    protected Person(Parcel in) {
        name = in.readString();
        surname = in.readString();
        dni = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(surname);
        dest.writeString(dni);
    }

}
//añadir fuente añadir oirntacion