package patterns.strategyFactory;

public class StrategyFactory {

    public static IDeduction getDeduction(StrategyMan strategyMan){
        IDeduction deduction = null;
        try {
            deduction = (IDeduction)Class.forName(strategyMan.getValue()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deduction;
    }
}
