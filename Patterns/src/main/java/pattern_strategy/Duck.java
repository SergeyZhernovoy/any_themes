package pattern_strategy;

public abstract class Duck {

     FlyBehavior flyBehavior;
     QuackBehavior quackBehavior;

     public Duck() {

     }

     public abstract void quack();
     public abstract void fly();

     public void setFlyBehavior(FlyBehavior flyBehavior) {
          this.flyBehavior = flyBehavior;
     }

     public void setQuackBehavior(QuackBehavior quackBehavior) {
          this.quackBehavior = quackBehavior;
     }
}
