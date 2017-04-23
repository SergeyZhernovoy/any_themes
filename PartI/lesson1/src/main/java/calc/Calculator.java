package calc;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Created by admin on 08.03.2017.
 */
public class Calculator {
    private double result;
    private AddMethod add = (value) -> value + result;
    private SubMethod sub = (value) -> result - value;

    public double getResult() {
        return result;
    }

    public void add(int value){
        result = add.add(value);
    }

    public void sub(int value){
        result = sub.sub(value);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.add(1);
        calculator.add(1);
        System.out.println(calculator.getResult());
    }

}
