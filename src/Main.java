import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Jan", "Kowalski"),
                new Person("Adam", "Kowalski"),
                new Person("Barbara", "Kowalski"),
                new Person("Andrzej", "Kowalski"),
                new Person("Józef", "Kowalski"),
                new Person("Jan", "Kowalski")
        );


        people
                .stream()
                .map(person -> person.lastName)
                .distinct()
                .forEach(s -> System.out.println(s));
    }
}

class Person {
    String name;
    String lastName;

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

}