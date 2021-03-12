package lesson1.p3;

public class Rect extends Figure {
    int a;
    int b;

    public Rect(int A, int B) {
        a = A;
        b = B;
    }

    public double Area() {
        return a * b;
    }

    public void PrintArea() {
        System.out.println("Площадь прямоугольника: " + Area());
    }
}

