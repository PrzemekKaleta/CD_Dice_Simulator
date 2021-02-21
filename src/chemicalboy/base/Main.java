package chemicalboy.base;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        boolean wePlay = true;

 /*       DicePattern dicePattern1 = new DicePattern();
        DicePattern dicePattern2 = new DicePattern();

        dicePattern1.setItIsDice(true);
        dicePattern2.setItIsDice(true);
        dicePattern1.setSides(6);
        dicePattern2.setSides(6);
        dicePattern1.setPositive(true);
        dicePattern2.setPositive(true);*/

/*        ProbabilityConveter probabilityConveter = new ProbabilityConveter();

        DiceChancePattern diceChancePattern1 = probabilityConveter.smallDiceChancePatternMaker(dicePattern1, 1);
        DiceChancePattern diceChancePattern2 = probabilityConveter.smallDiceChancePatternMaker(dicePattern1, 1);

        System.out.println(Arrays.toString(diceChancePattern1.getDiceChance().toArray()));
        System.out.println(Arrays.toString(diceChancePattern2.getDiceChance().toArray()));

        probabilityConveter.matrixResult(diceChancePattern1, diceChancePattern2);*/

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
