package chemicalboy.base;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean itIsOK = false;

        Scanner scanner = new Scanner(System.in);
        DiceConverter diceConverter = new DiceConverter();

        System.out.println("Wpisz kombinacje dla kości");

        while(!itIsOK){

            // String strToCheck = scanner.nextLine();

            String str1 = "k100 -3k12+2k10 -1k4 + 2 ";

            itIsOK = diceConverter.checkData(str1);

        }







    }
}
