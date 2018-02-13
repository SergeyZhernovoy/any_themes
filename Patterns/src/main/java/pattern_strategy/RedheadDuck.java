package pattern_strategy;

public class RedheadDuck extends Duck {

    public RedheadDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.setFlyBehavior(flyBehavior);
        this.setQuackBehavior(quackBehavior);
    }

    public RedheadDuck() {
    }

    @Override
    public void quack() {
        System.out.println(quackBehavior.quack());
    }

    @Override
    public void fly() {
        System.out.println(flyBehavior.fly());
    }
}
