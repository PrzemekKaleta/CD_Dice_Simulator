package chemicalboy.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiceConverter {

    ResultDTO resultDTO = new ResultDTO();
    DataRules dataRules = new DataRules();
    Talker talker = new Talker();



    public ResultDTO justRoll(String combination){

        String combinationCleared = combination.replaceAll("\\s","");

        String[] splitCombination = (combinationCleared.split("(?=\\+)|(?=-)"));

        for(int i = 0; i < splitCombination.length; i++) {

            firstCrash(splitCombination[i]);



        }

        return resultDTO;
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
                justRoll(combination);
                resultDTO.setCombinationIsOK(true);
                resultDTO.setInformationForUser("OK");
                resultDTO.setRollResult(1);
            }

        }

        return resultDTO;
    }

    public ArrayList<DicePattern> firstCrash(String str){

        int sign = 1;

        Pattern negative = Pattern.compile("-[k0-9]*");
        Matcher matcher = negative.matcher(str);
        if(matcher.matches()){
            System.out.println("negative " + str);
            sign = -1;
        }

        String str2 = str.replaceAll("\\+|-","");

        Pattern dice = Pattern.compile("[kK]");
        Matcher matcher1 = dice.matcher(str2);

        if(matcher1.find()){
            System.out.println("It is k : " + str2);

            diceCrush(str2);

        }else {
            System.out.println(Integer.parseInt(str2));
        }

    }

    public int[] diceCrush(String str){


        int howManyRoll = 1;
        int howDice;

        String[] rollDice = str.split("[kK]");

        System.out.println(Arrays.toString(rollDice));

        if(rollDice[0].equals("")){
            rollDice[0] = "1";
        }

        if(rollDice.length==2){
            howManyRoll = Integer.parseInt(rollDice[0]);
            howDice = Integer.parseInt(rollDice[1]);
        }else{
            howDice = Integer.parseInt(rollDice[0]);
        }
        int[] toBack = {howManyRoll, howDice};

        System.out.println(String.format("%s it means %s rolls by %s - sided dice", str, howManyRoll, howDice));

        return toBack;
    }


}
