package HW1.task3;

public class Circle extends Shape {
    int a;

    public Circle(int a) {
        this.a = a;
    }

    @Override
    public double area() {
        return Math.PI*a*a;
    }

    @Override
    public void printArea() {
        super.printArea();
    }
}
