package part2_3.javabean_di_approach;/**
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

    