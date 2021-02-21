package chemicalboy.base;

import java.util.ArrayList;

public class DiceChancePattern {

    private ArrayList<ChanceDotsDTO> diceChance;

    private int constant;

    public ArrayList<ChanceDotsDTO> getDiceChance() {
        return diceChance;
    }

    public void setDiceChance(ArrayList<ChanceDotsDTO> diceChance) {
        this.diceChance = diceChance;
    }

    public int getConstant() {
        return constant;
    }

    public void setConstant(int constant) {
        this.constant = constant;
    }


}
