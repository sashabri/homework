package block4.unit1.task1;


import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age = -1;
    protected String address;

    public Person(final String name, final String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(final String name, final String surname, int age) {
        this(name, surname);
        this.age = age;
    }

    public Person(final String name, final String surname, int age, String address) {
        this(name, surname, age);
        this.address = address;
    }


    public boolean hasAge() {
        return this.age != 0;
    }

    public boolean hasAddress() {
        return this.address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if(age < 0) {
            return OptionalInt.empty();
        } else {
            return OptionalInt.of(age);
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            this.age++;
        }
    }

    @Override
    public String toString() {
        return  name +
                " " + surname +
                (hasAge() ? "" : "age - " + age) +
                (hasAddress() ? "" : "address - " + address);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode() + surname.hashCode();
        if (hasAddress()) {
            result += address.hashCode();
        }
        return result;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.setSurname(surname);
        personBuilder.setAddress(address);
        return personBuilder;
    }
}
