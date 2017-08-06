package javabean_di_approach;

import java.util.Collection;

/**
 * @author Sergey Zhernovoy
 * create on 06.08.2017.
 */

public class OneManBand implements Performer{

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

    