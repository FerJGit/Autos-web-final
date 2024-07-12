package edu.ar.model;

public class Modelo {

    private int id;
    private int idMarca;
    private String nombre;
    
    public Modelo() {}
    
    public Modelo(int id, int idMarca, String nombre) {
        this.id = id;
        this.idMarca = idMarca;
        this.nombre = nombre;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdMarca() {
        return idMarca;
    }
    
    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return "Marca [getId()=" + getId() + ", getIdMarca()=" + getIdMarca() + ", getNombre()=" + getNombre() + "]";
    }
}
