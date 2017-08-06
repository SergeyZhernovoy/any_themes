package javabean_di_approach;/**
 * @author Sergey Zhernovoy
 * create on 06.08.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InstrumentalList implements Performer {
    private static final Logger logger = LoggerFactory.getLogger(InstrumentalList.class);

    private String song;
    private Instrument instrument;

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }


    @Override
    public void perform() throws PerformanceException {
        System.out.println("Playing " + song);
        instrument.play();
    }
}

    