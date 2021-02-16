package chemicalboy.base;

import java.util.ArrayList;
import java.util.Arrays;

public class DiceConverter {


    public boolean checkData(String str){

        String str2 = str.replaceAll("\\s","");

        System.out.println(str2);

        char[] takeAll = str2.toCharArray();

        System.out.println(Arrays.toString(takeAll));


        String[] part = str2.split("\\+");

        for(int i = 0; i < part.length ; i++){
            System.out.println(part[i]);
        }


        //System.out.println("I: " + Arrays.toString(str2.split("(?<=\\+)")));
        System.out.println("II: " + Arrays.toString(str2.split("(?=\\+)")));
        System.out.println("IV: " + Arrays.toString(str2.split("(?=\\+)|(?=-)")));
        //System.out.println("III: " + Arrays.toString(str2.split("((?<=\\+)|(?=\\+))")));

        ArrayList<Integer> positiveList = new ArrayList<>();
        ArrayList<Integer> negativeList = new ArrayList<>();


        for(int i = 0; i < takeAll.length; i++){

            if(takeAll[i]=='-'){
                negativeList.add(i);
            }else if(takeAll[i]=='+'){
                positiveList.add(i);
            }


        }

        System.out.println(negativeList.toString());
        System.out.println(positiveList.toString());


        return true;
    }


}
