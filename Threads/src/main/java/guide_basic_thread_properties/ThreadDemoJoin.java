package guide_basic_thread_properties;

import java.math.BigDecimal;

/**
 * @author Sergey Zhernovoy
 * create on 06.09.2017.
 */

public class ThreadDemoJoin {

    private static final BigDecimal FOUR = BigDecimal.valueOf(4);

    private static final int roundingMode = BigDecimal.ROUND_HALF_EVEN;

    private static BigDecimal result;

    public static void main(String[] args) {
        Runnable runnable = ()->{
          result = computePi(3);
        };

        Thread thread = new Thread(runnable);
        thread.start();
        try{
            thread.join();
        } catch (InterruptedException exc){

        }
        System.out.println(result);
    }

    /**
     * pi/4 = 4*arctan(1/5)-arctan(1/239)
     * @param digits
     * @return
     */
    private static BigDecimal computePi(int digits) {

        int scale = digits + 5;
        BigDecimal arctan1_5 = arctan(5, scale);
        BigDecimal arctan1_239 = arctan(239, scale);
        BigDecimal pi = arctan1_5.multiply(FOUR)
                                 .subtract(arctan1_239).multiply(FOUR);
        return pi.setScale(digits,BigDecimal.ROUND_HALF_EVEN);

    }

    /**
     * arctan(x) = x-(x^3)/3+(x^5)/5-(x^7)/7+(x^9)/9
     * @param inverseX ttt
     * @param scale
     * @return
     */
    private static BigDecimal arctan(int inverseX, int scale) {
        BigDecimal result, numer, term;
        BigDecimal invX = BigDecimal.valueOf(inverseX);
        BigDecimal invX2 = BigDecimal.valueOf(inverseX * inverseX);
        numer = BigDecimal.ONE.divide(invX,scale,roundingMode);
        result = numer;
        int i =1;
        do{
            numer = numer.divide(invX2,scale,roundingMode);
            int denom = 2 * i + 1;
            term = numer.divide(BigDecimal.valueOf(denom),scale,roundingMode);
            if((i % 2) != 0){
                result = result.subtract(term);
            } else {
                result = result.add(term);
            }
            i++;
        } while (term.compareTo(BigDecimal.ZERO) != 0);
        return result;
    }
}

    