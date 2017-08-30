package part2_3.replace_method_magik;/**
 * @author Sergey Zhernovoy
 * create on 29.08.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import interface_parts_for_all.PerformanceException;
import interface_parts_for_all.Performer;

public class Magician implements Performer {
    private static final Logger logger = LoggerFactory.getLogger(Magician.class);
    private String magicWord;
    private MagicBox magicBox;

    @Override
    public void perform() throws PerformanceException {
        System.out.println(magicWord);
        System.out.println("The magic box contents ...");
        System.out.println(magicBox.getContents());
    }

    public String getMagicWord() {
        return magicWord;
    }

    public void setMagicWord(String magicWord) {
        this.magicWord = magicWord;
    }

    public MagicBox getMagicBox() {
        return magicBox;
    }

    public void setMagicBox(MagicBox magicBox) {
        this.magicBox = magicBox;
    }
}

    