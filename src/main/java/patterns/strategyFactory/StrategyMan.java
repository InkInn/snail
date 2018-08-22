package patterns.strategyFactory;

public enum StrategyMan {

    steadyDeduction("patterns.strategyFactory.SteadyDeduction"),

    freeDeduction("patterns.strategyFactory.FreeDeduction");

    String value = "";

    private StrategyMan(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
