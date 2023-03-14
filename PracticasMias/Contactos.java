package PracticasMias;

public class Contactos {

    // Atributos

    String Nombre;
    int NumeroTel;
    String Email;

    // Constructores
    public Contactos(String nombre, int numeroTel, String email) {
        Nombre = nombre;
        NumeroTel = numeroTel;
        Email = email;
    }

    public Contactos() {

    }

    // Setters y getters
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getNumeroTel() {
        return NumeroTel;
    }

    public void setNumeroTel(int numeroTel) {
        NumeroTel = numeroTel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

}
