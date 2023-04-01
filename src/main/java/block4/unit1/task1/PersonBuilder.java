package block4.unit1.task1;

public class PersonBuilder {
    private String name;
    private String surname;
    private int age = -1;
    private String address;

    public PersonBuilder setName(final String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(final String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
            if (age >= 0) {
                this.age = age;
            } else {
                throw new IllegalArgumentException("Возраст должен быть целым неорицательным числом.");
            }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {

        if (name == null || surname == null) {
            throw new IllegalStateException("Не заполнены поля - name или surname.");
        }

        return new Person(name, surname, age, address);
    }
}
