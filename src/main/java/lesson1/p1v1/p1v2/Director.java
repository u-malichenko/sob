package lesson1.p1v1.p1v2;

public class Director {

    public void constructPerson(Builder builder) {
        builder.setFirstName("firstName");
        builder.setLastName("lastName");
        builder.setMiddleName("middleName");
        builder.setCountry("country");
        builder.setAddress("address");
        builder.setPhone("phone");
        builder.setAge( 35);
        builder.setGender("gender");
    }
}
