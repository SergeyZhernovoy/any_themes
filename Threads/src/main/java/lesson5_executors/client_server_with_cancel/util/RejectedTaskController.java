package lesson5_executors.client_server_with_cancel.util;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Sergey Zhernovoy
 * create on 19.12.2017.
 */

public class RejectedTaskController implements RejectedExecutionHandler {
    /**
     * Method that may be invoked by a {@link ThreadPoolExecutor} when
     * {@link ThreadPoolExecutor#execute execute} cannot accept a
     * task.  This may occur when no more threads or queue slots are
     * available because their bounds would be exceeded, or upon
     * shutdown of the Executor.
     */
    @Override
    public void rejectedExecution(Runnable task, ThreadPoolExecutor executor) {
        Command command = (Command) task;
        Socket clientSocket = command.getSocket();
        try{
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
            String message = "The server is shutting down."
                    + "You request can not be served."
                    + "Shutting Down: "
                    + String.valueOf(executor.isShutdown())
                    + ". Terminated: "
                    + String.valueOf(executor.isTerminated())
                    + ". Terminating: "
                    + String.valueOf(executor.isTerminating());
            out.println(message);
            out.close();
            clientSocket.close();
        } catch (IOException exc){
            exc.printStackTrace();
        }
    }
}

    