package pattern_strategy;

public class MallardDuck extends Duck {

    public MallardDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.setFlyBehavior(flyBehavior);
        this.setQuackBehavior(quackBehavior);
    }

    public MallardDuck() {
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
