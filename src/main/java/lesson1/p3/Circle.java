package lesson1.p3;

public class Circle extends Figure {
    int a;

    public Circle(int A) {
        a = A;
    }

    public double Area() {
        return Math.PI * a * a;
    }

    public void PrintArea() {
        System.out.println("Площадь круга: " + Area());
    }
}