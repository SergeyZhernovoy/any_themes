package pattern_decorator;

public class Decafe extends Beverage {

    private Beverage innerBeverage;

    public Decafe(Beverage innerBeverage) {
        super("Make decafe");
        this.innerBeverage = innerBeverage;
    }

    public Decafe(String description) {
        super(description);
    }

    @Override
    public Integer cost() {
        return 13 + innerBeverage.cost();
    }
}
