package chemicalboy.base;

public class DataRules {

    private int maximumLengthCombination = 20;

    private int[] diceSides = {3,4,6,8,10,12,20,100};

    public int getMaximumLengthCombination() {
        return maximumLengthCombination;
    }

    public int[] getDiceSides() {
        return diceSides;
    }
}
