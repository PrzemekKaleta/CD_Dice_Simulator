package chemicalboy.base;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        boolean wePlay = true;

        DicePattern dicePattern = new DicePattern();

        dicePattern.setItIsDice(true);
        dicePattern.setSides(5);
        dicePattern.setPositive(true);

        ProbabilityConveter probabilityConveter = new ProbabilityConveter();

        DiceChancePattern diceChancePattern = probabilityConveter.smallDiceChancePatternMaker(dicePattern, -1);

        System.out.println(Arrays.toString(diceChancePattern.getDiceChance().toArray()));


        Listener listener = new Listener();

        String command = listener.hello();

        if(command.equals("QUIT")){
            wePlay = false;
        }

        while(wePlay){
            switch (command){
                case "MAIN":
                    command = listener.main();
                    break;
                case "STATISTIC":
                    command = listener.statistic();
                    break;
                case "ROLL":
                    command = listener.roll();
                    break;
                case "MIX":
                    command = listener.mix();
                    break;
                case "QUIT":
                    wePlay = false;

            }

        }

    }
}
