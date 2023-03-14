package Ejercico2;

public class Main {
    public static void main(String[] args) {
        
        Persona Persona1 = new Persona("123456789D", "Hermes", "Pérez", 18);
        Persona Persona2 = new Persona("987654321F", "Xavi", "Pérez", 16);

        System.out.println(Persona1.getDNI()+" "+Persona1.getNombre()+" "+Persona1.getApellidos()+" "+Persona1.getEdad());
        System.out.println(Persona2.getDNI()+" "+Persona2.getNombre()+" "+Persona2.getApellidos()+" "+Persona2.getEdad());


    }
}
