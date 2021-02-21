package chemicalboy.base;

import java.util.StringJoiner;

public class ChanceDotsDTO {

    private double chance;

    private int dots;

    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }

    public int getDots() {
        return dots;
    }

    public void setDots(int dots) {
        this.dots = dots;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ChanceDotsDTO.class.getSimpleName() + "[", "]")
                .add("chance=" + chance)
                .add("dots=" + dots)
                .toString();
    }
}
