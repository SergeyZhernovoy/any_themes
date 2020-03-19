package input_output_new_api.lesson2_channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @author Sergey Zhernovoy
 * create on 02.12.2017.
 */

public class ChannelDemo {
    public static void main(String[] args) {
        ReadableByteChannel src  = Channels.newChannel(System.in);
        WritableByteChannel dest = Channels.newChannel(System.out);
        try{
            copy(src,dest);
        } catch (IOException exc){
            System.err.println("I/O error:" + exc.getMessage());
        } finally {
            try{
                src.close();
                dest.close();
            } catch (IOException exc){
                exc.printStackTrace();
            }
        }
    }

    private static void copy(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(2048);
        while (src.read(buffer) != -1){
            buffer.flip();
            dest.write(buffer);
            buffer.compact();
        }
        buffer.flip();
        while (buffer.hasRemaining()){
            dest.write(buffer);
        }

    }

    private static void copyAlt(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(2048);
        while (src.read(buffer) != -1){
            buffer.flip();
            while (buffer.hasRemaining()){
                dest.write(buffer);
            }
            buffer.clear();
        }
    }
}

    