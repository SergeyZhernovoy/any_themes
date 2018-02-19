package pattern_decorator;

public class Ligth extends Beverage {

    public Ligth(String description) {
        super(description);
    }

    @Override
    public Integer cost() {
        return 2;
    }
}
