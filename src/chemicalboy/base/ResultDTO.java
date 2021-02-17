package chemicalboy.base;

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
}
