import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class TryLockExample {

    private final ReentrantLock lock = new ReentrantLock();

    public void performTask() {
        try {
            // Try to acquire the lock for 2 seconds
            if (lock.tryLock(2, TimeUnit.SECONDS)) {
                try {
                    System.out.println(Thread.currentThread().getName() + " acquired the lock.");
                    // Simulate task
                    Thread.sleep(1000);
                } finally {
                    lock.unlock();  // Always release the lock
                    System.out.println(Thread.currentThread().getName() + " released the lock.");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock in time.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TryLockExample example = new TryLockExample();

        // First thread will acquire the lock and hold it for 1 second
        Thread t1 = new Thread(example::performTask, "Thread-1");
        // Second thread will try to acquire the lock and may fail if it times out
        Thread t2 = new Thread(example::performTask, "Thread-2");

        t1.start();
        t2.start();
    }
}
