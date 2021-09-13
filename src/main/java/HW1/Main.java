package HW1;

import HW1.task1.Person;
import HW1.task1.PersonBuilder;
import HW1.task2.LightWeightCar;
import HW1.task2.Lorry;
import HW1.task3.Circle;
import HW1.task3.Shape;
import HW1.task3.Square;
import HW1.task3.Triangle;

import java.util.Arrays;
import java.util.List;

public class Main {
//1. Создать builder для класса Person со следующими полями:
//   String firstName, String lastName, String middleName, String country, String address, String phone, int age, String gender.
//2. Описать ошибки в коде (см. задание в методичке) и предложить варианты оптимизации.
//3. Написать пример кода, который реализует принцип полиморфизма, на примере фигур — круг, квадрат, треугольник.

    public static void main(String[] args) {

//        task 1

        Person person1 = new PersonBuilder()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setMiddleName("Ivanovich")
                .setCountry("Russian")
                .setAddress("addres")
                .setPhone("9-999-99-99")
                .setAge(23)
                .setGender("Male")
                .build();
        System.out.println(person1);


//        task2

        LightWeightCar lightWeightCar = new LightWeightCar();
        lightWeightCar.start();
        lightWeightCar.open();
        lightWeightCar.move();

        Lorry lorry = new Lorry();
        lorry.open();
        lorry.start();
        lorry.move();
        lorry.stop();

//        task3

        List<Shape> shapeList = Arrays.asList(new Circle(5), new Square(6),new Triangle(5,7,5));
        shapeList.forEach(Shape::printArea);
    }
}
