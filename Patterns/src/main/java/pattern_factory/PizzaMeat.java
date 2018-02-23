package pattern_factory;

public class PizzaMeat implements Pizza {
    @Override
    public String description() {
        return "Meat pizza";
    }

    @Override
    public Integer cost() {
        return 120;
    }
}
