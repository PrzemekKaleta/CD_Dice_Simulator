package chemicalboy.base;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean itIsOK = false;

        Scanner scanner = new Scanner(System.in);
        DiceConverter diceConverter = new DiceConverter();

        System.out.println("Wpisz kombinacje dla kości");

        String strOK1 = "2k10";
        String strOK2 = "-k12";
        String strOK3 = "-k12-20";
        String strOK4 = "3K8+  4k20 -16";
        String strOK5 = "5k8 +k5 +k100";
        String strOK6 = "3k100+k3-5";

        String strNOK1 = "2z10";
        String strNOK2 = "-k-12";
        String strNOK3 = "12k";
        String strNOK4 = "a3K8+ - 4k20 -16";
        String strNOK5 = "5k8 +k5 ++k100";
        String strNOK6 = "3k100+k3-5k";
        String strNOK7 = "3Kk8+  4k20 -16";


        System.out.println(diceConverter.checkData(strOK1));
        System.out.println(diceConverter.checkData(strOK2));
        System.out.println(diceConverter.checkData(strOK3));
        System.out.println(diceConverter.checkData(strOK4));
        System.out.println(diceConverter.checkData(strOK5));
        System.out.println(diceConverter.checkData(strOK6));
/*        System.out.println(diceConverter.checkData(strNOK1));
        System.out.println(diceConverter.checkData(strNOK2));
        System.out.println(diceConverter.checkData(strNOK3));
        System.out.println(diceConverter.checkData(strNOK4));
        System.out.println(diceConverter.checkData(strNOK5));
        System.out.println(diceConverter.checkData(strNOK6));
        System.out.println(diceConverter.checkData(strNOK7));*/







    }
}
