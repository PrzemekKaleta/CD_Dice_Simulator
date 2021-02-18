package chemicalboy.base;

import java.util.StringJoiner;

public class ResultDTO {

    private boolean combinationIsOK;

    private String informationForUser;

    private int rollResult;

    public boolean isCombinationIsOK() {
        return combinationIsOK;
    }

    public void setCombinationIsOK(boolean combinationIsOK) {
        this.combinationIsOK = combinationIsOK;
    }

    public String getInformationForUser() {
        return informationForUser;
    }

    public void setInformationForUser(String informationForUser) {
        this.informationForUser = informationForUser;
    }

    public int getRollResult() {
        return rollResult;
    }

    public void setRollResult(int rollResult) {
        this.rollResult = rollResult;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ResultDTO.class.getSimpleName() + "[", "]")
                .add("combinationIsOK=" + combinationIsOK)
                .add("informationForUser='" + informationForUser + "'")
                .add("rollResult=" + rollResult)
                .toString();
    }
}
