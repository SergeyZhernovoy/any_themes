package part2_3.javabean_di_approach;

import interface_parts_for_all.Instrument;
import interface_parts_for_all.PerformanceException;
import interface_parts_for_all.Performer;

import java.util.Collection;

/**
 * @author Sergey Zhernovoy
 * create on 06.08.2017.
 */

public class OneManBand implements Performer {

    private Collection<Instrument> instruments;

    @Override
    public void perform() throws PerformanceException {
        for(Instrument instrument : instruments){
            instrument.play();
        }
    }

    public void setInstruments(Collection<Instrument> instruments) {
        this.instruments = instruments;
    }

}

    