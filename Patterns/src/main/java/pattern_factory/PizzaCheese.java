package pattern_factory;

public class PizzaCheese implements Pizza {

    @Override
    public String description() {
        return "cheeze";
    }

    @Override
    public Integer cost() {
        return 100;
    }
}
