package mx.edu.utez.trabajito29062026;

public class Caballos {
    private String name;
    private String origen;
    private String color;
    private int edad;
    private int velocidad;

    public Caballos() {
    }
    public Caballos(String name, String origen, String color, int edad, int velocidad) {
        this.name = name;
        this.origen = origen;
        this.color = color;
        this.edad = edad;
        this.velocidad = velocidad;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOrigen() {
        return origen;
    }
    public void setOrigen(String origen) {
        this.origen = origen;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getVelocidad() {
        return velocidad;
    }
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
}

