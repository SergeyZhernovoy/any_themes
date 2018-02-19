package pattern_decorator;

public abstract class Beverage {
    private String description;

    public Beverage(String description) {
        this.description = description;
    }

    public abstract Integer cost();

    public String getDescription() {
        return description;
    }

}
