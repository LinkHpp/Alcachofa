/**
 * @author Hermes Pérez Parrondo
 * @email herperpar@alu.edu.gva.es
 * @create date 2023-03-14 13:23:55
 */

package Practica1;




public class AgendaContactos {


    // VARIABLES GLOBALES
    public static int maxC = 100; // Máximo nº de contactos
    public static int numC = 0; // Nº de contactos registrados
    public static Contactos AgendaArrays[] = new Contactos[maxC]; // Arrays de objeto Contactos

    



    public static int getMaxC() {
        return maxC;
    }

    public static void setMaxC(int maxC) {
        AgendaContactos.maxC = maxC;
    }

    public static int getNumC() {
        return numC;
    }

    public static void setNumC(int numC) {
        AgendaContactos.numC = numC;
    }

    public static Contactos[] getAgendaArrays() {
        return AgendaArrays;
    }

    public static void setAgendaArrays(Contactos[] agendaArrays) {
        AgendaArrays = agendaArrays;
    }

    /**
     * FUNCIONES DE MOSTRAR CONTACTOS
     */

    // Muestra la información solo del contacto 'pos' (índice de los vectores)
    public static void verContactoPos(int pos) {
        System.out.println(pos + ". " + AgendaArrays[pos].getNombre() + " - " + AgendaArrays[pos].getNumeroTel() + " - "
                + AgendaArrays[pos].getEmail());
    }

    // Muestra la información de todos los contactos
    public static void verContactosTodos() {
        for (int i = 0; i < numC; i++) {
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
        if (numC < maxC) {
            AgendaArrays[numC] = new Contactos(n, t, c);
            numC++;
        } else {
            System.out.println("ERROR: No se puede agregar contacto. Lista llena.");
        }
    }

    // Elimina de los vectores el contacto en la posición 'pos'
    public static void eliminarContacto(int pos) {
        if (pos >= 0 && pos < numC) {
            eliminarPosDeVector(AgendaArrays, pos);
            numC--;
        } else {
            System.out.println("ERROR: No se puede eliminar contacto. Posición fuera de rango.");
        }
    }

    // Elimina la posición 'pos' de 'vector' (mueve todos los elementos >pos una
    // posición a la izquierda)
    public static void eliminarPosDeVector(Contactos[] vector, int pos) {
        for (int i = pos; i < (numC - 1); i++) {
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
        int[] vpos = new int[maxC];
        // Nº de posiciones encontradas
        int npos = 0;

        // Recorremos 'vector' buscando el texto 'buscar' en sus posiciones
        // Guardaremos en 'vpos' las posiciones que contengan 'buscar'
        for (int i = 0; i < numC; i++) {
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
        for (int i = 0; i < numC; i++) {
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
        int[] vpos = new int[maxC];
        // Nº de posiciones encontradas
        int npos = 0;

        // Recorremos 'vector' buscando el texto 'buscar' en sus posiciones
        // Guardaremos en 'vpos' las posiciones que contengan 'buscar'
        for (int i = 0; i < numC; i++) {
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
    public static int[] buscarGlobal(/* Contactos Array, */ String buscar) {

        // Vector donde guardaremos las posiciones encontradas
        int[] vpos = new int[maxC];
        // Nº de posiciones encontradas
        int npos = 0;

        // Recorremos los vectores buscando el texto 'buscar' en sus posiciones
        // Guardaremos en 'vpos' las posiciones que contengan 'buscar'
        for (int i = 0; i < numC; i++) {
            // Comprobamos
            boolean encontradoN = AgendaArrays[i].getNombre().toUpperCase().contains(buscar.toUpperCase());
            boolean encontradoT = AgendaArrays[i].getNumeroTel().toUpperCase().contains(buscar.toUpperCase());
            boolean encontradoC = AgendaArrays[i].getEmail().toUpperCase().contains(buscar.toUpperCase());
            if (encontradoN || encontradoT || encontradoC) {
                vpos[npos] = i;
                npos++;
            }
        }

        // Reducimod el tamaño de 'vpos' al mínimo y lo devolvemos
        vpos = Arrays.copyOf(vpos, npos);
        return vpos;

    }
}
