package ru.bloch.builder;

/**
 * @author Sergey Zhernovoy
 */
public class Calzone extends Pizza {

    private final boolean sauceinside;

    public static class Builder extends Pizza.Builder<Builder> {

        private boolean sauceInside = false; // По умолчанию

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override
        public Calzone build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
    private Calzone(Builder builder) {
        super(builder);
        sauceinside = builder.sauceInside;
    }

    @Override
    public String toString() {
        return "Calzone{" +
                "sauceInside=" + sauceinside +
                ", toppings=" + toppings +
                '}';
    }
}
