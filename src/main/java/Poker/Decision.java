package Poker;

public class Decision {

    DecisionType decisionType;
    int amount;

    Decision(DecisionType decisionType, int amount) {
        this.decisionType = decisionType;
        this.amount = amount;
    }

    Decision(DecisionType decisionType) {
        if(decisionType == DecisionType.RAISE) {
            throw new IllegalStateException("No way to choose 'Raise' without specifying the amount");
        }
        this.decisionType = decisionType;
    }
}
