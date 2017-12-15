package lesson5_executors.client_server.servers.concurrent;

import lesson5_executors.client_server.util.Constants;
import lesson5_executors.client_server.util.cache.ParallelCache;
import lesson5_executors.client_server.util.logger.Logger;
import lesson5_executors.client_server.wdi.WDIDAO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Sergey Zhernovoy
 * create on 12.12.2017.
 */

public class ConcurrentServer {

    private ThreadPoolExecutor threadPoolExecutor;

    private ParallelCache parallelCache;

    private volatile boolean stopped = false;

    private WDIDAO wdidao;

    public ConcurrentServer() {
        this.wdidao = WDIDAO.getDAO();
        this.threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        this.parallelCache = new ParallelCache();;
        System.out.println("Initialize completed.");
        Logger.initialize();
    }

    public void execute() throws IOException, InterruptedException {

        try(ServerSocket serverSocket = new ServerSocket(Constants.CONCURRENT_PORT)){
            do{
                try{
                    Socket socket = serverSocket.accept();
                    RequestTask requestTask = new RequestTask(socket,parallelCache,this);
                    this.threadPoolExecutor.execute(requestTask);
                } catch (IOException exc){
                    exc.printStackTrace();
                }
            } while (!stopped);
        }

        threadPoolExecutor.awaitTermination(1, TimeUnit.DAYS);
        parallelCache.shutdown();
        System.out.println("Cache ok");
        System.out.println("Main server thread ended");
    }

    public ThreadPoolExecutor getExecutor(){
        return threadPoolExecutor;
    }

    public ParallelCache getParallelCache() {
        return parallelCache;
    }

    public void shutdown(){
        this.stopped = true;
        System.out.println("Shutting down the server ... ");
        System.out.println("Shutting down executor ... ");
        threadPoolExecutor.shutdown();
        System.out.println("Executor ok");
        System.out.println("Shutting down logger");
        Logger.sendMessage("Shutting down logger");
        Logger.shutdown();
        System.out.println("Logger ok");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ConcurrentServer server = new ConcurrentServer();
        server.execute();
    }

}

    