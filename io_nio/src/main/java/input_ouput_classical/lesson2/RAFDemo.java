package input_ouput_classical.lesson2;/**
 * @author Sergey Zhernovoy
 * create on 11.10.2017.
 */


import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Write a small Java application named RAFDemo that opens file data in
 read/write mode, uses void write(int b) to write byte value 127
 followed by void writeChars(String s) to write string "Test"
 (minus the quotes) to this file, resets the file pointer to the start of the
 file, and read/outputs these values.
 */

public class RAFDemo {
    public static void main(String[] args) throws IOException {
        if(args.length > 0){
            RandomAccessFile raf = new RandomAccessFile(args[0],"rw");
            raf.write(127);
            raf.writeChars("Test");
            raf.seek(0);
            System.out.println(raf.readInt());
            for(int index = 0 ; index < raf.length(); index++){
                System.out.println(raf.readChar());
            }
            System.out.println();
        }
    }
}

    