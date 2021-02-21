package chemicalboy.base;

import java.util.ArrayList;

public class ProbabilityConveter {

    private int constant;


    public ArrayList<DiceChancePattern> bigDiceChancePatternsMaker (ArrayList<DicePattern> dicePatterns){

        ArrayList<DiceChancePattern> diceChancePatterns = new ArrayList<>();

        int cons = 0;

        for(int i = 0; i < dicePatterns.size(); i ++){


            DicePattern dicePattern = dicePatterns.get(i);

            int sign = 1;

            if(!dicePattern.isPositive()){
                sign = -1;
            }

            if(!dicePattern.isItIsDice()){

                cons = cons + (sign * dicePattern.getConstant());

            }else{

                diceChancePatterns.add(smallDiceChancePatternMaker(dicePattern, sign));

            }



        }

        System.out.println("Stała: " + cons);
        this.constant = cons;


        return diceChancePatterns;
    }

    public DiceChancePattern smallDiceChancePatternMaker (DicePattern dicePattern, int sign){

        DiceChancePattern diceChancePattern = new DiceChancePattern();

        ArrayList<ChanceDotsDTO> inChanceDotsDTO = new ArrayList<>();

        double sides = (double) dicePattern.getSides();

        double probability = 1 / sides;

        for(int i = 0; i < dicePattern.getSides(); i++){

            ChanceDotsDTO chanceDotsDTO = new ChanceDotsDTO();

            chanceDotsDTO.setChance(probability);
            chanceDotsDTO.setDots((i + 1)*sign);

            inChanceDotsDTO.add(chanceDotsDTO);

        }

        diceChancePattern.setDiceChance(inChanceDotsDTO);

        return diceChancePattern;

    }

    public int getConstant() {
        return constant;
    }

    public void setConstant(int constant) {
        this.constant = constant;
    }
}
