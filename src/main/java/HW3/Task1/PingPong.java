package HW3.Task1;

public class PingPong {

    private final Object mon = new Object();
    private volatile char currentLetter = 'i';

    public static void main(String[] args) {
        PingPong p = new PingPong();
        Thread t1 = new Thread(() -> {
            p.printPing();
        });
        Thread t2 = new Thread(() -> {
            p.printPong();
        });
        t1.start();
        t2.start();
    }

    public void printPing(){
        synchronized (mon){
            try {
                for (int i = 0; i < 10 ; i++) {
                    while (currentLetter != 'i'){
                        mon.wait();
                    }
                    System.out.println("ping");
                    currentLetter = 'o';
                    mon.notify();
                                    }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void printPong(){
        synchronized (mon){
            try {
                for (int i = 0; i < 10; i++) {
                    while (currentLetter != 'o'){
                        mon.wait();
                    }
                    System.out.println("pong");
                    currentLetter = 'i';
                    mon.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
