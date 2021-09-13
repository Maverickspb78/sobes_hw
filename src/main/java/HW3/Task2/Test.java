package HW3.Task2;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        SafeCounter safeCounter = new SafeCounter(0);

        Thread t3 = new Thread(() -> {
            for (int i = 0; i <10000 ; i++) {
                safeCounter.inc();
            }
        });

        Thread t4 = new Thread(() -> {
            for (int i = 0; i <10000 ; i++) {
                safeCounter.dec();
            }
        });

        t3.start();
        t4.start();
        t3.join();
        t4.join();

        System.out.println("exit count = " + safeCounter.getCount());
    }
}
