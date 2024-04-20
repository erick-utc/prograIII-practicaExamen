package com.example.practicaexamen.classes;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class cEmpresa extends RealmObject {
    @PrimaryKey
    private int IdEmpresa;
    private String Nombre;
    private String EMail;
    private String Telefono;
    private String Direccion;

    public cEmpresa() {
        IdEmpresa = 0;
        Nombre = "";
        EMail = "";
        Telefono = "";
        Direccion = "";
    }

    public int getIdEmpresa() {
        return IdEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        IdEmpresa = idEmpresa;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getEMail() {
        return EMail;
    }

    public void setEMail(String EMail) {
        this.EMail = EMail;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }
}
