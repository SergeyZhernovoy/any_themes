package application.api_string;/**
 * @author Sergey Zhernovoy
 * create on 08.10.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

public class LocaleDemo {
    private static final Logger logger = LoggerFactory.getLogger(LocaleDemo.class);

    public static void main(String[] args) {
        Locale locale = Locale.ITALIAN;
        System.out.println(locale.getCountry());
        System.out.println(locale.getDisplayCountry());
        System.out.println(locale.getDisplayLanguage());

    }
}

    