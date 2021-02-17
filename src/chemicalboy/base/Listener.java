package chemicalboy.base;

import java.util.Scanner;

public class Listener {

    Scanner scanner = new Scanner(System.in);
    Talker talker = new Talker();


    String hello (){
        talker.firstContact();
        return main();

    }

    String statistic(){
        System.out.println("statistic");
        return main();
    }

    String roll(){

        String rollCommand = "ROLL";
        talker.myRules();
        boolean rollIsOK = false;

        while (!rollIsOK) {
            String checkIt = scanner.nextLine();
            if(whatUserWantShort(checkIt).equals("OK")){
                System.out.println("roll to check and calculate");



            }else{
                rollCommand = checkIt;
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
