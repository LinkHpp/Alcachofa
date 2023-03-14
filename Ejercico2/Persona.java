package Ejercico2;

public class Persona {

// Atributos

private String DNI;
private String Nombre;
private String Apellidos;
private int Edad;

    public Persona(String DNI, String nombre, String apellidos, int edad) {
        this.DNI = DNI;
        this.Nombre = nombre;
        this.Apellidos = apellidos;
        this.Edad = edad;
    }



    public String getDNI() {
        return DNI;
    }
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }


    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }


    public String getApellidos() {
        return Apellidos;
    }
    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }


    public int getEdad() {
        return Edad;
    }
    public void setEdad(int edad) {
        Edad = edad;
    }




}
