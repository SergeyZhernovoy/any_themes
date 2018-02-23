package pattern_factory;

public class PizzaSimpleFactory implements SimpleFactory {
    @Override
    public Pizza createPizza(String typePizza){
        Pizza pizza = null;
        switch (typePizza){
            case "cheeze":
                pizza = new PizzaCheese();
                break;
            case "meat":
                pizza = new PizzaMeat();
                break;
            case "italian":
                pizza = new PizzaItalian();
                break;
        }
        return pizza;
    }
}
