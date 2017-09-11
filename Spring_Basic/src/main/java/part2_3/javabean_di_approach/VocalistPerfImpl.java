package part2_3.javabean_di_approach;

import interface_parts_for_all.PerformanceException;
import interface_parts_for_all.Performer;

/**
 * @author Sergey Zhernovoy
 * create on 28.08.2017.
 */

public class VocalistPerfImpl implements Performer {

    private String song;

    @Override
    public void perform() throws PerformanceException {
        System.out.println("Lu lu lu my song like "+song);
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }
}

    