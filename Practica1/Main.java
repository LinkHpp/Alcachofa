/**
 * @author Hermes Pérez Parrondo
 * @email herperpar@alu.edu.gva.es
 * @create date 2023-03-13 08:52:20
 */


package Practica1;

import java.util.Arrays;
import java.util.Scanner;

// CASO PRÁCTICO "AGENDA DE CONTACTOS" HECHO CON PROGRAMACIÓN ESTRUCTURADA (UNIDAD 5)

public class Main {



    // MAIN PRINCIPAL
    public static void main(String[] args) {

        // Variables auxiliares
        int opcion; // opcion del menú
        String nombre, email, telefono; // nombre, correo y teléfono
        String buscar; // término a buscar
        int posicion; // posicion
        int[] PosicionVect; // vector de posiciones

        // Bucle principal
        do {
            opcion = menu();

            switch (opcion) {
                case 1:
                    // Ver contactos
                    AgendaContactos.verContactosTodos();
                    break;
                case 2:
                    // Añadir contacto
                    System.out.print("¿Nombre? ");
                    nombre = pedirString();
                    System.out.print("¿Teléfono? ");
                    telefono = pedirString();
                    System.out.print("¿Correo? ");
                    email = pedirString();
                    AgendaContactos.agregarContacto(nombre, telefono, email);
                    break;
                case 3:
                    // Eliminar contacto
                    System.out.print("¿ID de contacto a eliminar? ");
                    posicion = pedirIntEnRango(0, AgendaContactos.numC - 1);
                    eliminarContacto(posicion);
                    break;
                case 4:
                    // Buscar por nombre
                    System.out.print("¿Nombre? ");
                    buscar = pedirString();
                    PosicionVect = buscarContactosNombre(AgendaContactos.AgendaArrays, buscar);
                    verContactosVector(PosicionVect);
                    break;
                case 5:
                    // Buscar por teléfono
                    System.out.print("¿Teléfono? ");
                    buscar = pedirString();
                    PosicionVect = buscarContactosTelefono(AgendaContactos.AgendaArrays, buscar);
                    verContactosVector(PosicionVect);
                    break;
                case 6:
                    // Buscar por correo
                    System.out.print("¿Correo? ");
                    buscar = pedirString();
                    PosicionVect = buscarContactosEmail(AgendaContactos.AgendaArrays, buscar);
                    verContactosVector(PosicionVect);
                    break;
                case 7:
                    // Búsqueda global
                    System.out.print("¿Término a buscar globalmente? ");
                    buscar = pedirString();
                    PosicionVect = AgendaContactos.buscarGlobal(buscar);
                    verContactosVector(PosicionVect);
                    break;
                case 8:
                    // Salir
                    System.out.println("¡Gracias! ¡Hasta la próxima!");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
                    break;
            }

            System.out.println("");
        } while (opcion != 8);
    }

    /**
     * FUNCIONES DEL MENÚ Y PEDIR DATOS AL USUARIO
     */

    // Muestra el menú y devuelve la opción elegida por el usuario
    public static int menu() {

        System.out.println("1. Ver contactos");
        System.out.println("2. Agregar contacto.");
        System.out.println("3. Eliminar contacto.");
        System.out.println("4. Buscar por nombre.");
        System.out.println("5. Buscar por teléfono");
        System.out.println("6. Buscar por correo.");
        System.out.println("7. Búsqueda global.");
        System.out.println("8. Salir.");
        System.out.print("¿Opción? ");

        int opcion = pedirIntEnRango(1, 8);

        return opcion;
    }

    // Pide al usuario un valor int, una y otra vez hasta que responde con valor en
    // rango
    public static int pedirIntEnRango(int min, int max) {

        Scanner in = new Scanner(System.in);
        int valor;

        do {
            valor = in.nextInt();
            if (valor < min || valor > max) {
                System.out.println("AVISO: No válido. Debe ser entre " + min + " y " + max);
                System.out.print("Vuelve a intentarlo: ");
            }
        } while (valor < min || valor > max);

        return valor;
    }

    // Pide al usuario un texto y lo devuelve
    public static String pedirString() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    /**
     * FUNCIONES DE MOSTRAR CONTACTOS
     */

    // Muestra la información solo del contacto 'pos' (índice de los vectores)
    public static void verContactoPos(int pos) {
        System.out.println(pos + ". " + AgendaContactos.AgendaArrays[pos].getNombre() + " - " + AgendaContactos.AgendaArrays[pos].getNumeroTel() + " - " + AgendaContactos.AgendaArrays[pos].getEmail());
    }

    // Muestra la información de todos los contactos
    public static void verContactosTodos() {
        for (int i = 0; i < AgendaContactos.numC; i++) {
            verContactoPos(i);
        }
    }

    // Muestra la información de los contactos indicados en 'vpos' (vector de
    // posiciones)
    public static void verContactosVector(int[] vpos) {
        for (int i = 0; i < vpos.length; i++) {
            verContactoPos(vpos[i]);
        }
    }

    /**
     * FUNCIONES DE AGREGAR Y ELIMINAR CONTACTOS
     */

    // Añade a los vectores la información de un contacto nuevo (n, t, c)
    public static void agregarContacto(String n, String t, String c) {
        if (AgendaContactos.numC < AgendaContactos.maxC) {
            AgendaContactos.AgendaArrays[AgendaContactos.numC] = new Contactos(n, t, c);
            AgendaContactos.numC++;
        } else {
            System.out.println("ERROR: No se puede agregar contacto. Lista llena.");
        }
    }

    // Elimina de los vectores el contacto en la posición 'pos'
    public static void eliminarContacto(int pos) {
        if (pos >= 0 && pos < AgendaContactos.numC) {
            eliminarPosDeVector(AgendaContactos.AgendaArrays, pos);
            AgendaContactos.numC--;
        } else {
            System.out.println("ERROR: No se puede eliminar contacto. Posición fuera de rango.");
        }
    }

    // Elimina la posición 'pos' de 'vector' (mueve todos los elementos >pos una
    // posición a la izquierda)
    public static void eliminarPosDeVector(Contactos[] vector, int pos) {
        for (int i = pos; i < (AgendaContactos.numC - 1); i++) {
            vector[i] = vector[i + 1];
        }
    }

    /**
     * FUNCIONES DE BUSCAR CONTACTOS
     */

    // Busca en 'vector' los String que contienen 'buscar'
    // Devuelve un vector con las posiciones en las que se ha encontrado
    public static int[] buscarContactosNombre(Contactos[] vector, String buscar) {

        // Vector donde guardaremos las posiciones encontradas
        int[] vpos = new int[AgendaContactos.maxC];
        // Nº de posiciones encontradas
        int npos = 0;

        // Recorremos 'vector' buscando el texto 'buscar' en sus posiciones
        // Guardaremos en 'vpos' las posiciones que contengan 'buscar'
        for (int i = 0; i < AgendaContactos.numC; i++) {
            if (vector[i].getNombre().toUpperCase().contains(buscar.toUpperCase())) {
                vpos[npos] = i;
                npos++;
            }
        }

        // Reducimod el tamaño de 'vpos' al mínimo y lo devolvemos
        vpos = Arrays.copyOf(vpos, npos);

        return vpos;
    }

    public static int[] buscarContactosEmail(Contactos[] vector, String buscar) {

        // Vector donde guardaremos las posiciones encontradas
        int[] vpos = new int[maxC];
        // Nº de posiciones encontradas
        int npos = 0;

        // Recorremos 'vector' buscando el texto 'buscar' en sus posiciones
        // Guardaremos en 'vpos' las posiciones que contengan 'buscar'
        for (int i = 0; i < AgendaContactos.numC; i++) {
            if (vector[i].getEmail().toUpperCase().contains(buscar.toUpperCase())) {
                vpos[npos] = i;
                npos++;
            }
        }

        // Reducimod el tamaño de 'vpos' al mínimo y lo devolvemos
        vpos = Arrays.copyOf(vpos, npos);

        return vpos;
    }

    public static int[] buscarContactosTelefono(Contactos[] vector, String buscar) {

        // Vector donde guardaremos las posiciones encontradas
        int[] vpos = new int[AgendaContactos.maxC];
        // Nº de posiciones encontradas
        int npos = 0;

        // Recorremos 'vector' buscando el texto 'buscar' en sus posiciones
        // Guardaremos en 'vpos' las posiciones que contengan 'buscar'
        for (int i = 0; i < AgendaContactos.numC; i++) {
            if (vector[i].getNumeroTel().toUpperCase().contains(buscar.toUpperCase())) {    
                vpos[npos] = i;
                npos++;
            }
        }

        // Reducimod el tamaño de 'vpos' al mínimo y lo devolvemos
        vpos = Arrays.copyOf(vpos, npos);

        return vpos;
    }

    // Busca en 'vn', 'vt' y 'vc' los String que contienen 'buscar'
    // Devuelve las posiciones en las que se ha encontrado

}