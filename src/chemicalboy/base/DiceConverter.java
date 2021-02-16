package chemicalboy.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiceConverter {


    public boolean checkData(String str){

        String str2 = str.replaceAll("\\s","");

        System.out.print(str2 +" ");


        //System.out.println("IV: " + Arrays.toString(str2.split("(?=\\+)|(?=-)")));
        ArrayList<String> allNeed = new ArrayList<>();
        String[] xxx = (str2.split("(?=\\+)|(?=-)"));

        boolean isOk = true;

        for(int i = 0; i < xxx.length; i++){

            Pattern pattern1 = Pattern.compile("[+-]?[1-9]*[Kk]?[1-9]+[0-9]*");
            Matcher matcher1 = pattern1.matcher(xxx[i]);
            //System.out.println(xxx[i]);
            //System.out.println(matcher1.find());
            //System.out.println(matcher1.matches());

            calculate(xxx[i]);

            if(!matcher1.matches()){
                isOk = false;
            }

        }


        return isOk;
    }

    public void calculate(String str){

        int sign = 1;

        Pattern negative = Pattern.compile("-[k0-9]*");
        Matcher matcher = negative.matcher(str);
        if(matcher.matches()){
            System.out.println("negative " + str);
            sign = -1;
        }

        String str2 = str.replaceAll("\\+|-","");

        System.out.println("after replace " + str2);

        Pattern dice = Pattern.compile("[kK]");
        Matcher matcher1 = dice.matcher(str2);

        if(matcher1.find()){
            System.out.println("It is k : " + str2);

            calculate2(str2);




        }

    }

    public void calculate2(String str){

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

        System.out.println(String.format("%s it means %s rolls by %s -sided dice", str, howManyRoll, howDice));


    }


}
