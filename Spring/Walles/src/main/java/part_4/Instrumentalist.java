package part_4;/**
 * @author Sergey Zhernovoy
 * create on 30.08.2017.
 */

import interface_parts_for_all.Instrument;
import interface_parts_for_all.PerformanceException;
import interface_parts_for_all.Performer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Instrumentalist implements Performer {

    @Autowired
    @Qualifier("saxofon")
    private Instrument instrument;

    @Override
    public void perform() throws PerformanceException {

    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }
}

    