package pattern_decorator;

public class DarkRoast extends Beverage {

    private Beverage innerBeverage;

    public DarkRoast(Beverage innerBeverage) {
        super("Make dark roast");
        this.innerBeverage = innerBeverage;
    }

    @Override
    public Integer cost() {
        return 5 + innerBeverage.cost();
    }
}
