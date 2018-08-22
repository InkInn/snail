package patterns.strategyFactory;

public class DeductionContext {

    private IDeduction deduction = null;

    public DeductionContext(IDeduction deduction){
        this.deduction = deduction;
    }

    public boolean exec(Card card, Trade trade){
        return this.deduction.exec(card,trade);
    }
}
