package lesson5_executors.client_server.servers.concurrent;

import lesson5_executors.client_server.clients.concurrency.RequestTask;
import lesson5_executors.client_server.util.Constants;
import lesson5_executors.client_server.wdi.WDIDAO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Sergey Zhernovoy
 * create on 12.12.2017.
 */

public class ConcurrentServer {

    private ThreadPoolExecutor threadPoolExecutor;

    private ParallelCache parallelCache;

    private ServerSocket serverSocket;

    private volatile boolean stopped = false;

    private WDIDAO wdidao;

    public ConcurrentServer(final WDIDAO wdidao) throws IOException {
        this.threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        this.wdidao = wdidao;
        this.serverSocket = new ServerSocket(Constants.CONCURRENT_PORT);
    }

    public void execute(){

        do{
            try{
              Socket socket = serverSocket.accept();
              RequestTask requestTask = new RequestTask(socket);
              this.threadPoolExecutor.execute(requestTask);
            } catch (IOException exc){

            }
        } while (!stopped);

    }

}

    