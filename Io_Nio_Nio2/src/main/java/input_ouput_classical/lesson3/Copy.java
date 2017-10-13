package input_ouput_classical.lesson3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Sergey Zhernovoy
 * create on 13.10.2017.
 */

public class Copy {
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;

    public Copy(String inputFilePath, String outputFilePath) throws FileNotFoundException {
        fileInputStream = new FileInputStream(inputFilePath);
        fileOutputStream = new FileOutputStream(outputFilePath);
    }

    public void copyFile() throws IOException {
        if (fileOutputStream != null && fileOutputStream != null){
            int byteVar;
            while((byteVar = fileInputStream.read()) != -1){
                System.out.println("process copy byte...");
                 fileOutputStream.write(byteVar);
            }

            if(fileOutputStream != null){
                fileOutputStream.close();
            }

            if(fileInputStream != null){
                fileInputStream.close();
            }

        }
    }

    public static void main(String[] args) {
        if(args.length > 0 && args[0] != null && args[1] != null){
            try {
                Copy copy = new Copy(args[0],args[1]);
                copy.copyFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

    