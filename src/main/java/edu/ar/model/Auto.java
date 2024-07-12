package edu.ar.model;

public class Auto {
    private int id;
    private int idMarca;
    private String marca;
    private int idModelo;
    private String modelo;
    private String version;
    private int anio;
    private String chasis;
    private String motor;
    private int idColor;
    private String color;
    
    public Auto() {}
    
    public Auto(int id, int idMarca, String marca, int idModelo, String modelo, String version, int anio, String chasis, String motor, int idColor, String color) {
        this.id = id;
        this.idMarca = idMarca;
        this.marca = marca;
        this.idModelo = idModelo;
        this.modelo = modelo;
        this.version = version;
        this.anio = anio;
        this.chasis = chasis;
        this.motor = motor;
        this.idColor = idColor;
        this.color = color;
    }

    public Auto(int idMarca, int idModelo, String version, int anio, String chasis, String motor, int idColor) {
        this.idMarca = idMarca;
        this.idModelo = idModelo;
        this.version = version;
        this.anio = anio;
        this.chasis = chasis;
        this.motor = motor;
        this.idColor = idColor;
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

    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getIdModelo() {
        return idModelo;
    }
    
    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getVersion() {
        return version;
    }
    
    public void setVersion(String version) {
        this.version = version;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio){
        this.anio = anio;
    }

    public String getChasis() {
        return chasis;
    }
    
    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getMotor() {
        return motor;
    }
    
    public void setMotor(String motor) {
        this.motor = motor;
    }

    public int getIdColor() {
        return idColor;
    }
    
    public void setIdColor(int idColor) {
        this.idColor = idColor;
    }

    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public String toString() {
        return "Marca [getId()=" + getId() + ", getIdMarca()=" + getIdMarca() + ", getMarca()=" + getMarca() + ", getIdModelo()=" + getIdModelo() + ", getModelo()=" + getModelo() + ", getVersion()=" + getVersion() + ", getAnio()=" + getAnio() + ", getChasis()=" + getChasis() + ", getMotor()=" + getMotor() + ", getChasis()=" + getChasis() + ", getColor()=" + getColor() + "]";
    }
}
