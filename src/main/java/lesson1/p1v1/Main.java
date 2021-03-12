package lesson1.p1v1;

public class Main {
    public static void main(String[] args) {
        Person person = new Person.Builder().addFirstName("Ivan").addLastName("Ivanov").build();
    }
}

class FirstName {
    private String firstName;

    public FirstName(String firstName) {
        this.firstName = firstName;
    }
}

class LastName {
    private String lastName;

    public LastName(String lastName) {
        this.lastName = lastName;
    }
}

class MiddleName {
    private String middleName;

    public MiddleName(String middleName) {
        this.middleName = middleName;
    }
}

class Country {
    private String country;

    public Country(String country) {
        this.country = country;
    }
}

class Address {
    private String address;

    public Address(String address) {
        this.address = address;
    }
}

class Phone {
    private String phone;

    public Phone(String phone) {
        this.phone = phone;
    }
}

class Age {
    private int age;

    public Age(int age) {
        this.age = age;
    }
}

class Gender {
    private String gender;

    public Gender(String gender) {
        this.gender = gender;
    }
}

class Person {
    private FirstName firstName;
    private LastName lastName;
    private MiddleName middleName;
    private Country country;
    private Address address;
    private Phone phone;
    private Age age;
    private Gender gender;

    public static class Builder {
        private FirstName firstName;
        private LastName lastName;
        private MiddleName middleName;
        private Country country;
        private Address address;
        private Phone phone;
        private Age age;
        private Gender gender;

        public Builder addFirstName(String firstName) {
            this.firstName = new FirstName(firstName);
            return this;
        }

        public Builder addLastName(String lastName) {
            this.lastName = new LastName(lastName);
            return this;
        }

        public Builder addMiddleName(String middleName) {
            this.middleName = new MiddleName(middleName);
            return this;
        }

        public Builder addCountry(String country) {
            this.country = new Country(country);
            return this;
        }

        public Builder addAddress(String address) {
            this.address = new Address(address);
            return this;
        }

        public Builder addPhone(String phone) {
            this.phone = new Phone(phone);
            return this;
        }

        public Builder addAge(int age) {
            this.age = new Age(age);
            return this;
        }

        public Builder addGender(String gender) {
            this.gender = new Gender(gender);
            return this;
        }

        public Person build() {
            return new Person();
        }
    }
}
