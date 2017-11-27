package input_output_new_api.lesson1_buffer;

import java.nio.ByteBuffer;

/**
 * @author Sergey Zhernovoy
 * create on 27.11.2017.
 */


public class BufferDemo {
    public static void main(String[] args) {
        ByteBuffer buffer1 = ByteBuffer.allocate(7);
        if(buffer1.hasArray()){
            System.out.println("Capacity " + buffer1.capacity());
            System.out.println("Array offset " + buffer1.arrayOffset());
            System.out.println("Limit "+ buffer1.limit());
            System.out.println("Position " + buffer1.position());
            System.out.println("Remaining " + buffer1.remaining());
            System.out.println(buffer1);
        }

        byte[] array = new byte[200];
        ByteBuffer buffer2 = ByteBuffer.wrap(array,10,50);
        if(buffer2.hasArray()){
            System.out.println("Capacity " + buffer2.capacity());
            System.out.println("buffered array " + buffer2.array());
            System.out.println("Array offset " + buffer2.arrayOffset());
            System.out.println("Limit "+ buffer2.limit());
            System.out.println("Position " + buffer2.position());
            System.out.println("Remaining " + buffer2.remaining());
            System.out.println(buffer2);
        }

        //**********************
        System.out.println("\n\nTest put get and abilitity buffer");
        //**********************
        System.out.println("Capacity " + buffer1.capacity());
        System.out.println("Limit "+ buffer1.limit());
        System.out.println("Position " + buffer1.position());
        System.out.println("Remaining " + buffer1.remaining());
        buffer1.put((byte) 10)
               .put((byte) 20)
               .put((byte) 30);

        for(int index = 0; index < buffer1.position(); index++){
            System.out.println(buffer1.get(index));
        }

        System.out.println("\n\nCurrent info");
        System.out.println("Capacity " + buffer1.capacity());
        System.out.println("Limit "+ buffer1.limit());
        System.out.println("Position " + buffer1.position());
        System.out.println("Remaining " + buffer1.remaining());


    }
}

    