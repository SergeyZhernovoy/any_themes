package application.api_string;/**
 * @author Sergey Zhernovoy
 * create on 08.10.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ChoiceFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class TextFormatDemo {
    private static final Logger logger = LoggerFactory.getLogger(TextFormatDemo.class);

    public static void main(String[] args) {
        System.out.println(" ------- Number Format ----------");
        double salary = 1234.5;
        System.out.println(NumberFormat.getCurrencyInstance().format(salary));
        System.out.println(NumberFormat.getCurrencyInstance(Locale.JAPAN).format(salary));
        System.out.println(NumberFormat.getNumberInstance().format(salary));
        System.out.println("-------Choice Format --------");
        String[] message = {"Current variable","Undefined type variable"};
        double[] numberMessage = new double[] {0,1};
        ChoiceFormat choiceFormat = new ChoiceFormat(numberMessage,message);
        System.out.println(choiceFormat.format(0));
        System.out.println(choiceFormat.format(1));
        /**
         * данный класс позволяет создавать сообщения для контроля множественности в сообщениях к примеру...
         */
        double countFile = 14;
        ChoiceFormat choiceFormat1 = new ChoiceFormat("0#нет открытых файлов|10#открыто меньше 15 файлов|15#открыто не менее 15 файлов");
        System.out.println(choiceFormat1.format(countFile));



    }
}

    