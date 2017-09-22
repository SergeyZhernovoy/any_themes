package horstmann_enter_course.lesson1;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Sergey Zhernovoy
 * create on 22.09.2017.
 */

public class AllSubDirectories {

    public List<File> getAllSubDirectories(File fileUp){
        List<File> directories = new ArrayList<>();
        if (fileUp.isDirectory()){
            directories = Stream.of(fileUp.listFiles(File::isDirectory))
                                .collect(Collectors.toList());
        }
        return directories;
    }

    public List<File> getAllSubDirectories(File fileUp, String ends){
        List<File> directories = new ArrayList<>();
        if (fileUp.isDirectory()){
            FilenameFilter filenameFilter = (file,end) -> file.getName().endsWith(end);
            directories = Stream.of(fileUp.listFiles((file,str)-> str.endsWith(ends))).collect(Collectors.toList());
        }
        return directories;
    }

    public static void main(String[] args) {
        if(args.length !=1){
            throw new IllegalArgumentException("Not have any argument");
        } else {
            AllSubDirectories allSubDirectories = new AllSubDirectories();
            List<File> files = allSubDirectories.getAllSubDirectories(new File(args[0]),"pdf");
            files.forEach(System.out::println);
        }

    }

}

    