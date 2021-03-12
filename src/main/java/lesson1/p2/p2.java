//package lesson1.p2;
//
////2. Описать ошибки в коде и предложить варианты оптимизации:
//interface Moveable {
//    void move();
//}
////интерфейсы можно объединить в один
//interface Stopable {
//    void stop();
//}
//
////я бы вместо кода гетеров и сетеров использовал аннотации ломбок
//abstract class Car {
//    //странно что поле класса публичное но имеет и сетеры и геттеры, я бы сделал его приватным
//    public Engine engine;
//    private String color;
//    private String name;
//
//    //сделал бы его абстрактным
//    protected void start() {
//        System.out.println("Car starting");
//    }
//
//    abstract void open();
//
//    //в этом куске кода нет такого возвращаемого класса
//    // есть возможность импортировать его из предыдущих примеров методички
//    public Engine getEngine() {
//        return engine;
//    }
//
//    public void setEngine(Engine engine) {
//        this.engine = engine;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
//
////странно что этот класс не имплементирует интерфейс остановки, я бы добавил
//class LightWeightCar extends Car implements Moveable {
//    //я бы сделал метод публичным для доступа из других пакетов
//    @Override
//    void open() {
//        System.out.println("Car is open");
//    }
//
//    @Override
//    public void move() {
//        System.out.println("Car is moving");
//    }
//}
//
////class Lorry extends Car, Moveable, Stopable {
//// множественное наследование не поддерживается
//// интерфейсы нужно имплементировать
//// необходимо имплементировать абстрактный метод родителя open
////странное название класса, я бы назвал более ясно
//
//class Lorry extends Car, Moveable, Stopable {
//
//    public void move() {
//        System.out.println("Car is moving");
//    }
//
//    public void stop() {
//        System.out.println("Car is stop");
//    }
//}