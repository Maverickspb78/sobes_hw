package HW1.task2;

public class Lorry extends Car implements Moveable, Stopable, Openable {
    public void move() {
        System.out.println("Car is moving");
    }

    public void stop() {
        System.out.println("Car is stop");
    }

    public void open() {
        System.out.println("Car is open");
    }
}
