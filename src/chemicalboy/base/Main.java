package chemicalboy.base;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean itIsOK = false;

        Scanner scanner = new Scanner(System.in);
        DiceConverter diceConverter = new DiceConverter();

        System.out.println("Wpisz kombinacje dla kości");

        while(!itIsOK){

            String strToCheck = scanner.next();

            itIsOK = diceConverter.checkData(strToCheck);

        }







    }
}
