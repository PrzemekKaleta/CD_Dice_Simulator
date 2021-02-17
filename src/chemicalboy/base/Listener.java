package chemicalboy.base;

import java.util.Scanner;

public class Listener {

    Scanner scanner = new Scanner(System.in);
    Talker talker = new Talker();





    String hello(){
        talker.firstContact();
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
