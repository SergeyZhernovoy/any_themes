package lesson5_executors.client_server_with_cancel.util;/**
 * @author Sergey Zhernovoy
 * create on 19.12.2017.
 */

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Класс позволяет сохранять переменные для статистики без всякой синхронизации
 */
public class ExecutorStatistics {
    private AtomicLong executionTime = new AtomicLong(0L);
    private AtomicInteger numTasks = new AtomicInteger(0);

    public long getTimes() {
        return executionTime.get();
    }

    public void addTime(long time) {
        this.executionTime.addAndGet(time);
    }

    public int getTasks() {
        return numTasks.get();
    }

    public void addTask() {
        this.numTasks.incrementAndGet();
    }

    @Override
    public String toString() {
        return "Executed tasks: " + this.getTasks() + ". Execution time=" + this.getTimes();
    }
}

    