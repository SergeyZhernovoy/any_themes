package pattern_strategy;

public class StartUI {
    public static void main(String[] args) {
        Duck duck = new RedheadDuck(new FlyBehaviorImpl(),new QuackBehaviorImpl());
        duck.fly();
        duck.quack();
    }
}
