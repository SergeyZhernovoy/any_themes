package lesson5_aspect_obj_programs.lesson2;/**
 * @author Sergey Zhernovoy
 * create on 18.09.2017.
 */

public class Volunteer implements Thinker {

    private String thougths;

    @Override
    public void thinkOfSomethings(String thougths) {
        this.thougths = thougths;
    }

    public String getThougths(){
        return this.thougths;
    }
}

    