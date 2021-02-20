package chemicalboy.base;

import java.util.StringJoiner;

public class DicePattern {

    boolean itIsDice;

    boolean positive;

    int sides;

    int constant;

    boolean isStandardDice;

    public boolean isItIsDice() {
        return itIsDice;
    }

    public void setItIsDice(boolean itIsDice) {
        this.itIsDice = itIsDice;
    }

    public boolean isPositive() {
        return positive;
    }

    public void setPositive(boolean positive) {
        this.positive = positive;
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    public int getConstant() {
        return constant;
    }

    public void setConstant(int constant) {
        this.constant = constant;
    }

    public boolean isStandardDice() {
        return isStandardDice;
    }

    public void setStandardDice(boolean standardDice) {
        isStandardDice = standardDice;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DicePattern.class.getSimpleName() + "[", "]")
                .add("itIsDice=" + itIsDice)
                .add("positive=" + positive)
                .add("sides=" + sides)
                .add("constant=" + constant)
                .add("isStandardDice=" + isStandardDice)
                .toString();
    }
}
