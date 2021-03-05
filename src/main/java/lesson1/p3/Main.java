package lesson1.p3;

public class Main {
    public static void main(String[] args) {
        Figure[] f = new Figure[5];
        f[0] = new Circle(1);
        f[1] = new Rect(1, 1);
        f[2] = new Triangle(1, 1, 1);
        f[3] = new Circle(1);
        f[4] = new Rect(1, 1);

        for (Figure figure : f) figure.PrintArea();
    }
}
