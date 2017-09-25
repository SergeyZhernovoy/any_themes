package lesson1;

import java.io.File;

/**
 * @author Sergey Zhernovoy
 * create on 25.09.2017.
 */

public class DumpRoots {
    public static void main(String[] args) {
        File[] roots = File.listRoots();
        for (File root : roots){
            System.out.println("Partition :"+root);
            System.out.println("Free space---------> "+root.getFreeSpace());
            System.out.println("Total space -------> "+root.getTotalSpace());
            System.out.println("Usable space-------> "+root.getUsableSpace());
        }
    }
}

    