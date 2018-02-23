package pattern_factory;

public class PizzaItalian implements Pizza {
    @Override
    public String description() {
        return "italian pizza";
    }

    @Override
    public Integer cost() {
        return 100;
    }
}
