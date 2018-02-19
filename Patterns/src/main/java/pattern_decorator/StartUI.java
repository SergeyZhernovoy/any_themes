package pattern_decorator;

public class StartUI {
    public static void main(String[] args) {
        Beverage beverage = new Ligth("light");
        Espresso espresso = new Espresso(beverage);
        Decafe decafe = new Decafe(espresso);
        HouseBlend houseBlend = new HouseBlend(decafe);
        System.out.println(houseBlend.getDescription() + " cost "+ houseBlend.cost());
    }
}
