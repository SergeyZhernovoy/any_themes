import org.junit.Assert;
import org.junit.Test;
import syntax_feature_basic.CalculatorHighPretension;

import static org.hamcrest.core.Is.is;

/**
 * Created by Sergey on 18.04.2017.
 */
public class CalculatorHighPretensionTest {

    @Test
    public void whenWeWantCalculateThatWeGetResult(){

        CalculatorHighPretension calculator = new CalculatorHighPretension();

        double operand = 1;

        calculator.setOperand(operand);

        double result = 0;

        Assert.assertThat(0,is((int)calculator.add(result,100d)));
        Assert.assertThat(0,is((int)calculator.add(result,100d)));
        Assert.assertThat(0,is((int)calculator.add(result,100d)));


    }


}