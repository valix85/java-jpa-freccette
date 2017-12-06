package Utility;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    public static String leggiStringa(){
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    };

    public static int leggiIntero(){
        Scanner s = new Scanner(System.in);
        try {
            return s.nextInt();
        }catch(InputMismatchException ex){
            System.out.println("Valore non valido, riprovare");
            return leggiIntero();
        }
    };

}
