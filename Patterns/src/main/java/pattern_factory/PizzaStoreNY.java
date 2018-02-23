package pattern_factory;

public class PizzaStoreNY extends PizzaStore {

    private SimpleFactory simpleFactory;

    public PizzaStoreNY(SimpleFactory simpleFactory){
        this.simpleFactory = simpleFactory;
    }

    @Override
    public Pizza createPizza(String type) {
        return simpleFactory.createPizza(type);
    }

    public static void main(String[] args) {
        PizzaStore pizzaStore = new PizzaStoreNY(new PizzaSimpleFactory());
        pizzaStore.orderPizza("italian");
    }

}
