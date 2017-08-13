package part2_3.javabean_di_approach;

import java.util.Map;

/**
 * @author Sergey Zhernovoy
 * create on 06.08.2017.
 */

public class OneManBandWithKey implements Performer{

    private Map<String,Instrument> instruments;

    @Override
    public void perform() throws PerformanceException {
       for(String key : this.instruments.keySet()){
           System.out.print(key+":");
           Instrument instrument = instruments.get(key);
           instrument.play();
       }
    }

    public void setInstruments(Map<String,Instrument> instruments) {
        this.instruments = instruments;
    }

}

    