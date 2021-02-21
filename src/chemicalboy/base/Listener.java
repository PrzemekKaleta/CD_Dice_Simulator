package chemicalboy.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Listener {

    Scanner scanner = new Scanner(System.in);
    Talker talker = new Talker();
    DiceConverter diceConverter = new DiceConverter();
    DataRules dataRules = new DataRules();
    ResultDTO resultDTO = new ResultDTO();
    ProbabilityConveter probabilityConveter = new ProbabilityConveter();


    String hello (){
        talker.firstContact();
        return main();

    }


    String statistic(){

        String statisticComand = "STATISTIC";
        talker.myRules();
        boolean rollIsOK = false;

        while (!rollIsOK) {
            String checkIt = scanner.nextLine();
            String command = whatUserWantShort(checkIt);
            if(command.equals("OK")){

                resultDTO = diceConverter.checkData(checkIt);

                if(resultDTO.isCombinationIsOK()){
                    ArrayList<DicePattern> dicePatterns = diceConverter.allDicePattern(checkIt);
                    ArrayList<DiceChancePattern> diceChancePatterns = probabilityConveter.bigDiceChancePatternsMaker(dicePatterns);
                    probabilityConveter.printDiceChancePattern(probabilityConveter.butcherForMatrix(diceChancePatterns));

                }else{
                    System.out.println(resultDTO.getInformationForUser());
                }

            }else{
                statisticComand = command;
                rollIsOK = true;
            }

        }

        return statisticComand;
    }

    String roll(){

        String rollCommand = "ROLL";
        talker.myRules();
        boolean rollIsOK = false;


        while (!rollIsOK) {
            String checkIt = scanner.nextLine();
            String command = whatUserWantShort(checkIt);
            if(command.equals("OK")){

                resultDTO = diceConverter.checkData(checkIt);

                if(resultDTO.isCombinationIsOK()){
                    ArrayList<DicePattern> dicePatterns = diceConverter.allDicePattern(checkIt);
                    resultDTO = diceConverter.rollsResult(dicePatterns);
                    System.out.println(resultDTO.getInformationForUser());
                    System.out.println("Wynik: " + resultDTO.getRollResult());
                }else{
                    System.out.println(resultDTO.getInformationForUser());
                }

            }else{
                rollCommand = command;
                rollIsOK = true;
            }

        }
        return rollCommand;

    }

    String mix(){
        System.out.println("mix");
        return main();
    }


    String main(){

        talker.always();
        talker.mainMenu();

        boolean itIsOk = false;
        String toReturn = "QUIT";

        while(!itIsOk){
            String requestUser = scanner.nextLine();

            String command = whatUserWant(requestUser);

            if(command.equals("BAD")){
                talker.badRequest();
            }else{
                itIsOk = true;
                toReturn = command;
            }

        }

        return toReturn;

    }

    String whatUserWantShort(String str){
        String toCheck = str.trim().toLowerCase();

        String command = "OK";

        switch (toCheck){
            case "w":
                command = "MAIN";
                break;
            case "q":
                command = "QUIT";
                break;
        }

        return command;

    }



    String whatUserWant(String str){
        String command = "BAD";

        String toCheck = str.trim().toLowerCase();

        switch (toCheck){
            case "w":
                command = "MAIN";
                break;
            case "q":
                command = "QUIT";
                break;
            case "s":
                command = "STATISTIC";
                break;
            case "r":
                command = "ROLL";
                break;
            case "m":
                command = "MIX";
                break;
        }

        return command;
    }


}
