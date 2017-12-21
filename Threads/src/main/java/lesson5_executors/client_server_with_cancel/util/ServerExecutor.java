package lesson5_executors.client_server_with_cancel.util;

import lesson5_executors.client_server.util.logger.Logger;
import lesson5_executors.client_server_with_cancel.server.Server;

import java.util.Date;
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


    /**
     * Creates a new {@code ThreadPoolExecutor} with the given initial
     * parameters and default thread factory and rejected execution handler.
     * It may be more convenient to use one of the {@link Executors} factory
     * methods instead of this general purpose constructor.
     * @throws NullPointerException     if {@code workQueue} is null
     */
    public ServerExecutor() {
        super(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new PriorityBlockingQueue<>());
        this.startTimes = new ConcurrentHashMap<>();
        this.executorStatistics = new ConcurrentHashMap<>();
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
                ExecutorStatistics statistics = executorStatistics.computeIfAbsent(command.getUsername(),n->new ExecutorStatistics());
                statistics.addExecutionTime(executionTime);
                statistics.addTask();
                Server.finishTask(command.getUsername(),command);
            } else {
                String message = "The task"
                        + command.hashCode() +  " of user"
                        + command.getUsername()+ " has been cancelled.";
                Logger.sendMessage(message);
            }
        } else {
                String message = "The exception" + t.getMessage() +  " has been thrown.";
                Logger.sendMessage(message);
        }
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        return new ServerTask<T>(runnable);
    }
}

    