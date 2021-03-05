package lesson1.p3;

public class Triangle extends Figure {
    int a;
    int b;
    int h;

    public Triangle(int A, int B, int H) {
        a = A;
        b = B;
        h = H;
    }

    public double Area() {
        return (a + b) * (double) h / 2;
    }

    public void PrintArea() {
        System.out.println("Площадь трапеции: " + Area());
    }
}
