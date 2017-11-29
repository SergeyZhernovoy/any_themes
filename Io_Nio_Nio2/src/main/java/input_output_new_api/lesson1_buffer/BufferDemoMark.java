package input_output_new_api.lesson1_buffer;

import java.nio.ByteBuffer;

/**
 * @author Sergey Zhernovoy
 * create on 29.11.2017.
 */

public class BufferDemoMark {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(7);

        System.out.println("----------------------");
        System.out.println("Capacity " + buffer.capacity());
        System.out.println("Array offset " + buffer.arrayOffset());
        System.out.println("Limit "+ buffer.limit());
        System.out.println("Position " + buffer.position());
        System.out.println("Remaining " + buffer.remaining());
        System.out.println("-----------------------");

        buffer.put((byte)10)
              .put((byte)20)
              .put((byte)30)
              .put((byte)40);
        buffer.limit(4);
        buffer.position(1).mark();

        System.out.println("----------------------");
        System.out.println("Capacity " + buffer.capacity());
        System.out.println("Array offset " + buffer.arrayOffset());
        System.out.println("Limit "+ buffer.limit());
        System.out.println("Position " + buffer.position());
        System.out.println("Remaining " + buffer.remaining());
        System.out.println("-----------------------");


        System.out.println(buffer.get());
        System.out.println();
        buffer.reset();

        System.out.println("----------------------");
        System.out.println("Capacity " + buffer.capacity());
        System.out.println("Array offset " + buffer.arrayOffset());
        System.out.println("Limit "+ buffer.limit());
        System.out.println("Position " + buffer.position());
        System.out.println("Remaining " + buffer.remaining());
        System.out.println("-----------------------");


        while(buffer.hasRemaining()){
            System.out.println(buffer.get());
        }

        System.out.println("----------------------");
        System.out.println("Capacity " + buffer.capacity());
        System.out.println("Array offset " + buffer.arrayOffset());
        System.out.println("Limit "+ buffer.limit());
        System.out.println("Position " + buffer.position());
        System.out.println("Remaining " + buffer.remaining());
        System.out.println("-----------------------");


    }
}

    