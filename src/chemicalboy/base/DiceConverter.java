package chemicalboy.base;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiceConverter {

    ResultDTO resultDTO = new ResultDTO();
    DataRules dataRules = new DataRules();
    Talker talker = new Talker();


    public ArrayList<DicePattern> allDicePattern(String combination){

        ArrayList<DicePattern> dicePatternArrayList = new ArrayList<>();
        String combinationCleared = combination.replaceAll("\\s","");

        String[] splitCombination = (combinationCleared.split("(?=\\+)|(?=-)"));

        for(int i = 0; i < splitCombination.length; i++) {

            boolean signPositive = true;

            Pattern negative = Pattern.compile("-[k0-9]*");
            Matcher matcher = negative.matcher(splitCombination[i]);
            if(matcher.matches()){
                signPositive = false;
            }

            String moduleSplitCombination = splitCombination[i].replaceAll("\\+|-","");

            Pattern dice = Pattern.compile("[kK]");
            Matcher matcher1 = dice.matcher(moduleSplitCombination);

            if(matcher1.find()){

                String[] splitedModule = moduleSplitCombination.split("[kK]");

                if(splitedModule[0].equals("")){
                    splitedModule[0] = "1";
                }

                int howManyRolls = Integer.parseInt(splitedModule[0]);
                int howManySides = Integer.parseInt(splitedModule[1]);

                boolean isStandard = false;

                for(int k = 0; k < dataRules.getDiceSides().length; k++){

                    if(howManySides == dataRules.getDiceSides()[k]){
                        isStandard = true;
                        break;
                    }
                }

                for(int j = 0; j < howManyRolls; j++){
                    DicePattern dicePattern = new DicePattern();

                    dicePattern.setItIsDice(true);
                    dicePattern.setPositive(signPositive);
                    dicePattern.setSides(howManySides);
                    dicePattern.setStandardDice(isStandard);

                    dicePatternArrayList.add(dicePattern);

                }

            }else {
                DicePattern dicePattern = new DicePattern();

                dicePattern.setItIsDice(false);
                dicePattern.setPositive(signPositive);
                dicePattern.setConstant(Integer.parseInt(moduleSplitCombination));

                dicePatternArrayList.add(dicePattern);
            }

        }

        return dicePatternArrayList;
    }


    public ResultDTO checkData(String combination){

        boolean isOk = true;

        String combinationCleared = combination.replaceAll("\\s","");

        if(combinationCleared.length()==0){
            resultDTO.setCombinationIsOK(false);
            resultDTO.setInformationForUser(talker.emptyRequest());
            resultDTO.setRollResult(0);
        }

        if(combinationCleared.length() > dataRules.getMaximumLengthCombination()){
            resultDTO.setCombinationIsOK(false);
            resultDTO.setInformationForUser(talker.requestTooLong(combinationCleared.length(),dataRules.getMaximumLengthCombination()));
            resultDTO.setRollResult(0);
        }else{

            String[] splitCombination = (combinationCleared.split("(?=\\+)|(?=-)"));
            ArrayList<String> badSplitedCombination = new ArrayList<>();

                for(int i = 0; i < splitCombination.length; i++) {

                Pattern pattern1 = Pattern.compile("[+-]?[1-9]*[Kk]?[1-9]+[0-9]*");
                Matcher matcher1 = pattern1.matcher(splitCombination[i]);

                if (!matcher1.matches()) {
                    isOk = false;
                    badSplitedCombination.add(splitCombination[i]);
                }
            }

            if(!isOk){
                resultDTO.setCombinationIsOK(false);
                resultDTO.setInformationForUser(talker.requestWithBadCombination(badSplitedCombination));
                resultDTO.setRollResult(0);
            }

            if(isOk){
                resultDTO.setCombinationIsOK(true);

            }

        }

        return resultDTO;
    }

    public ResultDTO rollsResult (ArrayList<DicePattern> dicePatterns){

        Random random = new Random();
        ResultDTO resultDTO = new ResultDTO();
        StringBuilder stringBuilder = new StringBuilder();

        resultDTO.setCombinationIsOK(true);

        int result = 0;

        for(int i = 0; i < dicePatterns.size(); i++){

            int sign = 1;

            if(!dicePatterns.get(i).isPositive()){
                sign = -1;
                stringBuilder.append("(-)");
            }

            if(dicePatterns.get(i).isItIsDice()){

                int sides = dicePatterns.get(i).getSides();
                int rollResult = random.nextInt(sides) + 1;

                if(!dicePatterns.get(i).isStandardDice){
                    stringBuilder.append("(typ nieznany)");
                }

                stringBuilder.append("k" + sides + "=" + rollResult + " ");

                result = result + (sign * rollResult);



            }else{
                stringBuilder.append(dicePatterns.get(i).getConstant() + " ");
                result = result + (sign * dicePatterns.get(i).getConstant());
            }

        }

        System.out.println(result);
        String rollInformation = stringBuilder.toString().trim();
        resultDTO.setInformationForUser("Przebieg: " + rollInformation);
        resultDTO.setRollResult(result);

        return resultDTO;

    }

}
