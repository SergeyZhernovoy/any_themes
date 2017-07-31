package save_politics;/**
 * @author Sergey Zhernovoy
 * create on 31.07.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Socket;

public class EvilConnect {
    private static final Logger logger = LoggerFactory.getLogger(EvilConnect.class);
    private Socket socket;
    private String connectPath;
    private Integer port;

    public EvilConnect(String connect,Integer port){
        this.connectPath = connect;
        this.port = port;
    }

    public void setConnect(){
        try{
            socket = new Socket(connectPath,port);
            System.out.println("Подключено !");
        } catch (SecurityException | IOException e ){
            System.out.println("Security exception: не удалось подключиться.");
        }
    }

    public static void main(String[] args) {
        EvilConnect evilConnect = new EvilConnect("172.217.22.35",80);
        evilConnect.setConnect();
    }

}

    