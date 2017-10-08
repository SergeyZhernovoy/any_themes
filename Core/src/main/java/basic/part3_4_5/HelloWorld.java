package basic.part3_4_5;/**
 * @author Sergey Zhernovoy
 * create on 31.07.2017.
 */

/**
 * в опциях java запускаем с ключами -ea (enable assertion) -da (disable assertion)
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        assert(a > b);
    }
}

    