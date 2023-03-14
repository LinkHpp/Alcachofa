package Ejercicio1;

public class Main {
    

    public static void main(String[] args){
        Punto Punto1, Punto2, Punto3;

        Punto1 = new Punto(0, 5);
        Punto2 = new Punto(10, 10);
        Punto3 = new Punto(-3, 7);
        

        System.out.println(Punto1.x +", "+ Punto1.y);
        System.out.println(Punto2.x +", "+ Punto2.y);
        System.out.println(Punto3.x +", "+ Punto3.y);


        SumPos(Punto1.x, Punto1.y, 4, 7);
    }

    public static void SumPos(int Puntox, int Puntoy, int Cord1x, int Cord2y){


        Puntox += Cord1x;
        Puntoy += Cord2y;

        System.out.println(Puntox +", "+ Puntoy);


    }


    
    
  

}
