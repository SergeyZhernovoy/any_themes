package pattern_decorator;

public class Strong extends Beverage {

    public Strong(String description) {
        super(description);
    }

    @Override
    public Integer cost() {
        return 3;
    }
}
