package lesson1;

import java.io.File;
import java.util.Date;

/**
 * @author Sergey Zhernovoy
 * create on 26.09.2017.
 */

public class Touch {

    private File file;

    public Touch(File file){
        this.file = file;
    }

    public boolean setCurrentTime(long time){
        boolean result = false;
        if(file.exists()){
            file.setLastModified(time);
            result = true;
        }
        return result;
    }

    public static void main(String[] args) {
        if(args.length != 0){
            Touch touch = new Touch(new File(args[0]));
            Long time = new Date().getTime();
            time += 999999;
            if(touch.setCurrentTime(time)){
                System.out.println("Success");
            }
        }
    }

}

    