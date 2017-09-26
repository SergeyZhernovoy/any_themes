package horstmann_enter_course.lesson1;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Sergey Zhernovoy
 * create on 26.09.2017.
 */

public class ArrayFileSorting {

    public File[] sortArrayFile(File[] files) {
        if (files != null && files.length > 0) {

            List<File> directories = Stream.of(files)
                    .filter(file -> file.isDirectory())
                    .sorted()
                    .collect(Collectors.toList());
            List<File> fileList = Stream.of(files)
                    .filter(file -> file.isFile())
                    .sorted()
                    .collect(Collectors.toList());

            return (File[]) Stream.concat(directories.stream(), fileList.stream()).toArray();


        }
        return files;
    }
}

    