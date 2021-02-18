package chemicalboy.base;

import java.util.ArrayList;

public class Talker {

    void firstContact(){
        System.out.println("Cześć, jestem progarmem do symulacji rzutu kośćmi.");

    }

    void mainMenu(){
        System.out.println("Wybierz tryb zabawy: \"s\" - statystyki, \"r\" - rzut lub \"m\" - mieszany.");
    }

    void always(){
        System.out.println("Aby wyjść z progamu wybierz \"q\" lub \"w\" aby powrócić do wyboru opcji");
    }

    void myRules(){
        System.out.println("Wybierz kombinację z pośród dostępnych kości: K3, K4, K6, K8, K10, K12, K20 i K100 lub stwórz swoją własną");
        System.out.println("Wpisz kombinację np. 2K10 + k4 - 2 i zatwierdź ENTER, pomiędzy kośćmi musi być znak + lub -");
    }
    void badRequest(){
        System.out.println("nieporawne polecenie spróbuj jeszcze raz");
    }

    String requestTooLong(int lenth, int board){
        return String.format("zbyt długa kombinacja %s znaków, przy ograniczeniu %s znaków", lenth, board);
    }

    String requestWithBadCombination(ArrayList<String> badCombination){
        return String.format("Nieporawne kombinacje w %s miejscach: %s", badCombination.size(), badCombination.toString());

    }
    String emptyRequest(){
        return "Pusta kombinacja";
    }


}
