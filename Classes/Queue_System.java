package Classes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Queue_System {

    // Handles concurrent transactions one by one
    private ExecutorService transactionQueue;
    // Handles background automated tasks
    private ScheduledExecutorService scheduledQueue;

    public Queue_System() {
        // A single-thread executor to processes Transaction 1 by 1
        this.transactionQueue = Executors.newSingleThreadExecutor();
        // A Thread Pool for background tasks
        this.scheduledQueue = Executors.newScheduledThreadPool(1);
    }

    //Used to add Transaction process to the queue
    public void submitTransaction(Runnable transactionTask) {
        System.out.println("[QueueSystem] Transaction added to the processing queue");
        transactionQueue.submit(transactionTask);
    }

    //Used to add a schedule tasks that gonna happen repeatly like add interest rate every month
    public void scheduleRecurringTask(Runnable task, int initialDelay, int periodSeconds) {
        System.out.println("[QueueSystem] task scheduled.");
        scheduledQueue.scheduleAtFixedRate(task, initialDelay, periodSeconds, TimeUnit.SECONDS);
    }

    // For clear every process so its leave no zombie processes
    public void shutdownSystem() {
        System.out.println("[QueueSystem] Shutting down queues...");
        transactionQueue.shutdown();
        scheduledQueue.shutdown();
    }
}
