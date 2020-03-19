package input_ouput_classical.lesson4_file_writer_reader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Sergey Zhernovoy
 * create on 26.11.2017.
 */

public class FWFRDemo {
    final static String MSG = "Test message";

    public static void main(String[] args) throws IOException {
        try(FileWriter fileWriter = new FileWriter("temp")){
            fileWriter.write(FWFRDemo.MSG,0,MSG.length());
        }
        char[] buf = new char[MSG.length()];
        try(FileReader fileReader = new FileReader("temp")){
            fileReader.read(buf,0,MSG.length());
            System.out.println(buf);
        }
    }
}

    