package input_ouput_classical.lesson3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

/**
 * @author Sergey Zhernovoy
 * create on 15.10.2017.
 */

public class Scramble {

    private final int KEY_LENGTH = 256;
    private String issuesFile;
    private String destinationFile;

    public Scramble(String issuesFile, String destinationFile){
        this.issuesFile = issuesFile;
        this.destinationFile = destinationFile;
    }

    public void encryption(){
        try {
            try(FileInputStream fis = new FileInputStream(this.issuesFile); FileOutputStream fos = new FileOutputStream(this.destinationFile)){
                ScrambledOutputStream scrambledOutputStream = new ScrambledOutputStream(fos,makeMap());
                int b;
                while((b = fis.read())!= -1){
                    System.out.println("encrypt file from "+this.issuesFile + " to "+this.destinationFile +" at " + new Date());
                    scrambledOutputStream.write(b);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int[] makeMap(){
        int[] map = new int[KEY_LENGTH];
        for(int index = 0; index < KEY_LENGTH; index++ ){
            map[index] = index;
        }
        Random random = new Random(0);
        for (int index = 0; index < KEY_LENGTH ;index++){
            int n = random.nextInt(KEY_LENGTH);
            int temp = map[index];
            map[index] = map[n];
            map[n] = temp;
        }
        return map;
    }

    public static void main(String[] args) {
        if(args.length == 2){
            Scramble scramble = new Scramble(args[0],args[1]);
            scramble.encryption();
        }
    }

}

    