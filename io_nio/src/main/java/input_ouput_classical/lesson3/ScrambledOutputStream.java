package input_ouput_classical.lesson3;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Sergey Zhernovoy
 * create on 15.10.2017.
 */

public class ScrambledOutputStream extends FilterOutputStream {

    private int[] map;

    public ScrambledOutputStream(OutputStream out, int[] map){
        super(out);
        if(map == null){
           throw new NullPointerException("map is null");
        }
        if(map.length != 256){
           throw new IllegalArgumentException("map.length != 256");
        }
        this.map = map;
    }

    @Override
    public void write(int b) throws IOException {
        out.write(map[b]);
    }
}

    