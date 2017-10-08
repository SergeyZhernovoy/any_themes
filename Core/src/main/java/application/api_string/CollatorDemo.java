package application.api_string;/**
 * @author Sergey Zhernovoy
 * create on 08.10.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.Collator;
import java.util.Locale;

/**Класс предоставляет возможность сравнения на локальных языках в юникоде
 * @see Collator
 */
public class CollatorDemo {
    private static final Logger logger = LoggerFactory.getLogger(CollatorDemo.class);

    public static void main(String[] args) {
        //1) пример на немецком
        String fun = "Spa\u00df";
        String later = "sp\u00e4ter";

        Collator german = Collator.getInstance(Locale.GERMAN);
        if(german.compare(fun,later) > 0){
            System.out.println("true");
        }
        //2) как сравнить
        String str1 = "Ёжик";
        String str2 = "ЕЖик";
        Collator russian = Collator.getInstance(new Locale("ru","RU"));
        russian.setStrength(Collator.PRIMARY);
        if(russian.compare(str1,str2) == 0){
            System.out.println("Строки идентичны:" + str1 + " " + str2);
        }



    }

}

    