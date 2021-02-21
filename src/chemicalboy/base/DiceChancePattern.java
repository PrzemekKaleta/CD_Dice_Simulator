package chemicalboy.base;

import java.util.ArrayList;
import java.util.StringJoiner;

public class DiceChancePattern {

    private ArrayList<ChanceDotsDTO> diceChance;

    public ArrayList<ChanceDotsDTO> getDiceChance() {
        return diceChance;
    }

    public void setDiceChance(ArrayList<ChanceDotsDTO> diceChance) {
        this.diceChance = diceChance;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DiceChancePattern.class.getSimpleName() + "[", "]")
                .add("diceChance=" + diceChance)
                .toString();
    }
}
