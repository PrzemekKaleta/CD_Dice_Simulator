package chemicalboy.base;

public class DiceConverter {


    public boolean checkData(String str){

        

        String[] part = str.split("\\+");

        for(int i = 0; i < part.length ; i++){
            System.out.println(part[i]);
        }


        return true;
    }


}
