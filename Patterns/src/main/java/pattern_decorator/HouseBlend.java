package pattern_decorator;

public class HouseBlend extends Beverage {
    private Beverage innerBeverage;

    public HouseBlend(Beverage innerBeverage) {
        super("Make house blend");
        this.innerBeverage = innerBeverage;
    }

    @Override
    public Integer cost() {
        return 8 + innerBeverage.cost();
    }
}
