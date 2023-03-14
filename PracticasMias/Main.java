/**
 * @author Hermes Pérez Parrondo
 * @email herperpar@alu.edu.gva.es
 * @create date 2023-03-13 08:39:21
 */

package PracticasMias;




public class Main {
    public static void main(String[] args) {

        Contactos AgendaArray[] = new Contactos[10];

        for(int i = 0; i <= 9; i++){
            AgendaArray[i]= new Contactos("Hermes", 644407423, "herperpar@alu.edu.gva.es");
        }

        System.out.println(AgendaArray[7].getNombre());

        AgendaArray[2].setNombre("Xavi");

        System.out.println(AgendaArray[2].getNombre());

        AgendaArray[5].setNombre("Zayd");

        System.out.println(AgendaArray[5].getNombre());

    }
}
