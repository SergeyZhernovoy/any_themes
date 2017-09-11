package example_by_3;/**
 * @author Sergey Zhernovoy
 * create on 09.08.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxLength {
    private static final Logger logger = LoggerFactory.getLogger(MaxLength.class);

    public static int countLowerCase(String string){
        return (int)string
                    .chars()
                    .filter(Character::isLowerCase)
                    .count();
    }

    public static String mostLowerCaseString(List<String> args){
        return args
                .stream()
                .max(Comparator.comparing(MaxLength::countLowerCase))
                .orElse("");
    }

    public static void main(String[] args) {
        List<String> myWords = new ArrayList<>();
        myWords.add("Я помню чудное мгновенье");
        myWords.add("Передо мной явилась ты");
        myWords.add("Передо Мной явилась тыsasa");
        myWords.add("Передо Мной явилась тыasasas");
        System.out.println(MaxLength.mostLowerCaseString(myWords));
    }

}

    