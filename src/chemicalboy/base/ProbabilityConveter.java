package chemicalboy.base;

import java.util.*;
import java.util.stream.Collectors;

public class ProbabilityConveter {

    private int constant;


    public void printDiceChancePattern(DiceChancePattern diceChancePattern){

        for(int i = 0; i < diceChancePattern.getDiceChance().size(); i++){

            int dots = diceChancePattern.getDiceChance().get(i).getDots();
            double chance = diceChancePattern.getDiceChance().get(i).getChance() * 100;

            System.out.println(String.format("result %s - %.2f %%", dots, chance));

        }

    }


    public DiceChancePattern butcherForMatrix(ArrayList<DiceChancePattern> allDCP){

        int numberOfDCP = allDCP.size();

        DiceChancePattern mixedDCP = allDCP.get(0);

        for(int i = 1; i < numberOfDCP; i++){

            mixedDCP = matrixResult(mixedDCP, allDCP.get(i));

        }

        return mixedDCP;

    }



    public DiceChancePattern matrixResult(DiceChancePattern firstDCP, DiceChancePattern secondDCP){

        DiceChancePattern shortMatrixResult = new DiceChancePattern();

        ArrayList<ChanceDotsDTO> longChanceDots = new ArrayList<>();
        ArrayList<ChanceDotsDTO> shortChanceDots = new ArrayList<>();
        ArrayList<ChanceDotsDTO> firstChanceDots = firstDCP.getDiceChance();
        ArrayList<ChanceDotsDTO> secondChanceDots = secondDCP.getDiceChance();


        for(int i = 0; i < firstChanceDots.size(); i++){
            for(int j = 0; j <secondChanceDots.size(); j++){

                double chance = firstChanceDots.get(i).getChance() * secondChanceDots.get(j).getChance();
                int dotsSum = firstChanceDots.get(i).getDots() + secondChanceDots.get(j).getDots();

                ChanceDotsDTO chanceDotsDTO = new ChanceDotsDTO();
                chanceDotsDTO.setDots(dotsSum);
                chanceDotsDTO.setChance(chance);

                longChanceDots.add(chanceDotsDTO);
            }
        }

        Set<Integer> posibleSumDots = longChanceDots.stream().map(chanceDotsDTO -> chanceDotsDTO.getDots()).collect(Collectors.toSet());


        Iterator<Integer> iterator = posibleSumDots.iterator();

        while(iterator.hasNext()){

            int dots = iterator.next();
            double propability = 0;

            for(int j = 0 ; j <longChanceDots.size(); j++) {

                if (dots == longChanceDots.get(j).getDots()) {
                    propability = propability + longChanceDots.get(j).getChance();

                }
            }

            ChanceDotsDTO chanceDotsDTO = new ChanceDotsDTO();
            chanceDotsDTO.setDots(dots);
            chanceDotsDTO.setChance(propability);
            shortChanceDots.add(chanceDotsDTO);


         }

         shortMatrixResult.setDiceChance(shortChanceDots);

        return shortMatrixResult;

    }


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
