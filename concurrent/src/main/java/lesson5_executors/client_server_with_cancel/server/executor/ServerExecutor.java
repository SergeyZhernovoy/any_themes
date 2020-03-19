package lesson5_executors.client_server_with_cancel.server.executor;

import lesson5_executors.client_server.util.logger.Logger;
import lesson5_executors.client_server_with_cancel.server.Server;
import lesson5_executors.client_server_with_cancel.util.Command;

import java.util.Date;
import java.util.Map.Entry;
import java.util.concurrent.*;

/**
 * @author Sergey Zhernovoy
 * create on 19.12.2017.
 */

public class ServerExecutor extends ThreadPoolExecutor {

    private ConcurrentHashMap<Runnable,Date> startTimes;
    private ConcurrentHashMap<String, ExecutorStatistics> executorStatistics;
    private static int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    private static int MAXIMUM_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    private static long KEEP_ALIVE_TIME = 10;
    private static RejectedTaskController REJECTED_TASK_CONTROLLER = new RejectedTaskController();
    private final Server server;


    /**
     * Creates a new {@code ThreadPoolExecutor} with the given initial
     * parameters and default thread factory and rejected execution handler.
     * It may be more convenient to use one of the {@link Executors} factory
     * methods instead of this general purpose constructor.
     * @throws NullPointerException     if {@code workQueue} is null
     */
    public ServerExecutor(final Server server) {
        super(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new PriorityBlockingQueue<>(),REJECTED_TASK_CONTROLLER);
        this.startTimes = new ConcurrentHashMap<>();
        this.executorStatistics = new ConcurrentHashMap<>();
        this.server = server;
    }

    /**
     * Method invoked prior to executing the given Runnable in the
     * given thread.  This method is invoked by thread {@code t} that
     * will execute task {@code r}, and may be used to re-initialize
     * ThreadLocals, or to perform logging.
     * <p>
     * <p>This implementation does nothing, but may be customized in
     * subclasses. Note: To properly nest multiple overridings, subclasses
     * should generally invoke {@code super.beforeExecute} at the end of
     * this method.
     *
     * @param t the thread that will run task {@code r}
     * @param r the task that will be executed
     */
    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        startTimes.put(r,new Date());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        ServerTask<?> task =(ServerTask<?>)r;
        Command command = task.getCommand();

        if(t == null){
            if(!task.isCancelled()){
                Date startDate = startTimes.remove(r);
                Date endDate = new Date();
                long executionTime = endDate.getTime() - startDate.getTime();
                ExecutorStatistics statistics = executorStatistics.computeIfAbsent(command.getUserName(),n->new ExecutorStatistics());
                statistics.addExecutionTime(executionTime);
                statistics.addTask();
                this.server.finishTask(command.getUserName(),command);
            } else {
                String message = "The task"
                        + command.hashCode() +  " of user"
                        + command.getUserName()+ " has been cancelled.";
                Logger.sendMessage(message);
            }
        } else {
                String message = "The exception" + t.getMessage() +  " has been thrown.";
                Logger.sendMessage(message);
        }
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        return new ServerTask<T>((Command) runnable);
    }

    public void writeStatistics() {

        for(Entry<String,ExecutorStatistics> entry : executorStatistics.entrySet()){
            String user = entry.getKey();
            ExecutorStatistics stats = entry.getValue();
            Logger.sendMessage(user+": "+ stats);
        }

    }
}

    