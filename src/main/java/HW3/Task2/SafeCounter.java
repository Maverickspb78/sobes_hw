package HW3.Task2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SafeCounter {
    private int count;
    private final Lock lock = new ReentrantLock();

    public SafeCounter(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void inc(){
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public void dec(){
        lock.lock();
        count--;
        lock.unlock();
    }

}
