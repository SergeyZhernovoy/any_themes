package lesson1;

import java.io.File;
import java.io.IOException;

/**
 * @author Sergey Zhernovoy
 * create on 25.09.2017.
 */

public class TempFileDemo {

    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("java.io.tmpdir"));
        File temp = File.createTempFile("text",".txt");
        System.out.println(temp);
        temp.deleteOnExit();
    }

}

    