package input_output_new_api.lesson1_buffer;

import java.nio.CharBuffer;

/**
 * @author Sergey Zhernovoy
 * create on 29.11.2017.
 */

public class BufferDemo2Flip {

    private String[] poem = {
      "Roses are red",
      "Violets are blue",
      "Sugar is sweet",
      "And so are you"
    };

    public static void main(String[] args) {
        BufferDemo2Flip bufferDemo2Flip = new BufferDemo2Flip();
        bufferDemo2Flip.processReadWriteBuffer();
    }

    public void processReadWriteBuffer(){
        CharBuffer buffer = CharBuffer.allocate(50);
        for(int i = 0;i < poem.length; i++ ){
            for (int j= 0; j< poem[i].length(); j++){
                buffer.put(poem[i].charAt(j));
            }
            buffer.flip();
            while (buffer.hasRemaining()){
                System.out.print(buffer.get());
            }
            buffer.clear();
            System.out.println();
        }
    }

}

    