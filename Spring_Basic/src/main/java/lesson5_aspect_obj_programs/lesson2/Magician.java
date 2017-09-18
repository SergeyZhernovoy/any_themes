package lesson5_aspect_obj_programs.lesson2;/**
 * @author Sergey Zhernovoy
 * create on 18.09.2017.
 */

public class Magician implements MindReader {
    private String thougths;

    @Override
    public void interceptThougths(String thougths) {
        System.out.println("Intercepting volunteer's thougths");
        this.thougths = thougths;

    }

    @Override
    public String getThougths() {
        return this.thougths;
    }
}

    