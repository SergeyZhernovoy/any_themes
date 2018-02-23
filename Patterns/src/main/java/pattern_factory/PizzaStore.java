package pattern_factory;

public abstract class PizzaStore {

    public abstract Pizza createPizza(String type);

    public void orderPizza(String type){
        Pizza pizza = createPizza(type);
        System.out.println("I like pizza");
        System.out.println("What pizza do I like ?");
        System.out.println(pizza.description());
        System.out.println("by cost is " + pizza.cost());
     }
}
