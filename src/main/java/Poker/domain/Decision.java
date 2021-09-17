package Poker.domain;

public class Decision {

    public DecisionType decisionType;
    public int amount;

    public Decision(DecisionType decisionType, int amount) {
        this.decisionType = decisionType;
        this.amount = amount;
    }

    public Decision(DecisionType decisionType) {
        if(decisionType == DecisionType.RAISE) {
            throw new IllegalStateException("No way to choose 'Raise' without specifying the amount");
        }
        this.decisionType = decisionType;
    }
}
