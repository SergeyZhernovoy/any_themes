package lesson1;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author Sergey Zhernovoy
 * create on 21.09.2017.
 */

public class HelloWorld_IO {
    public static void main(String[] args) throws IOException {

        if(args.length != 1){
            System.err.println("usage: java PathInfo path");
            System.exit(1);
        } else {
            File file  = new File(args[0]);

            System.out.println(" ---------- PATH---------");

            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("Canoncial path: " + file.getCanonicalPath());
            System.out.println("Name = " + file.getName());
            System.out.println("Parent = " + file.getParent());
            System.out.println("Path = " + file.getPath());
            System.out.println("Is absolute =  " + file.isAbsolute());

            System.out.println("-----------PROPERTY FILE/DIRECTORY----------");

            System.out.println("About = " + file + ":");
            System.out.println("Exists " + file.exists());
            System.out.println("Is directory = " + file.isDirectory());
            System.out.println("Is file = " + file.isFile());
            System.out.println("Is hidden = " + file.isHidden());
            System.out.println("Last modified =  " + new Date(file.lastModified()));
            System.out.println("Length =  " + file.length());
        }


    }
}

    