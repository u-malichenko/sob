package lesson1.p1v1.p1v2;

public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        PersonBuilder personBuilder = new PersonBuilder();
        director.constructPerson(personBuilder);
        Person person = personBuilder.getResult();
        System.out.print(person.toString());
    }
}
