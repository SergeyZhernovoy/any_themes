package pattern_decorator;

public class Espresso extends Beverage {

    private Beverage innerBeverage;

    public Espresso (Beverage beverage) {
        super("Espresso make");
        this.innerBeverage = beverage;
    }

    public Espresso(String description) {
        super(description);
    }

    @Override
    public Integer cost() {
        return 12 + innerBeverage.cost();
    }
}
