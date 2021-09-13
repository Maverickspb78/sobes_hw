package HW1.task3;

public class Square extends Shape {

    int a;

    public Square(int a) {
        this.a = a;

    }

    @Override
    public double area() {
        return a*a;
    }
}
