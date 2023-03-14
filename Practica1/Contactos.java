/**
 * @author Hermes Pérez Parrondo
 * @email herperpar@alu.edu.gva.es
 * @create date 2023-03-14 13:24:06
*/

package Practica1;

public class Contactos {

    // Atributos

    String Nombre;
    String NumeroTel;
    String Email;

    public Contactos(String nombre, String numeroTel, String email) {
        Nombre = nombre;
        NumeroTel = numeroTel;
        Email = email;
    }

    public Contactos() {

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNumeroTel() {
        return NumeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        NumeroTel = numeroTel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

}
