package chemicalboy.base;

import java.util.ArrayList;

public class ProbabilityConveter {


    public ArrayList<DiceChancePattern> bigDiceChancePatternsMaker (ArrayList<DicePattern> dicePatterns){

        ArrayList<DiceChancePattern> diceChancePatterns = new ArrayList<>();


        for(int i = 0; i < dicePatterns.size(); i ++){

            int constant = 0;

            DicePattern dicePattern = dicePatterns.get(i);

            int sign = 1;

            if(!dicePattern.isPositive()){
                sign = -1;
            }

            if(!dicePattern.isItIsDice()){

                constant = constant + (sign * dicePattern.getConstant());
            }else{

                diceChancePatterns.add(smallDiceChancePatternMaker(dicePattern, sign));

            }

            dicePattern.setConstant(constant);

        }


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





}
