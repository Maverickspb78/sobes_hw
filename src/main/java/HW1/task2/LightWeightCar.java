package HW1.task2;

public class LightWeightCar extends Car implements Moveable, Openable{
    public void move() {
        System.out.println("Car is moving");
    }

    public void open() {
        System.out.println("Car is open");
    }
}
