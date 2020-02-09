import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

        // Utworzymy posortowana liste Stringow (name + lastName z Person) z Listy Person
        // Odfiltrujemy zaczynajace sie nie na samogloske
        // stringi wielka litera (calosc napisu)
        // na kolekcji stringow foreach z lambda - wydrukowanie do konsoli

        final Predicate<String> vowelAtTheBeginningPredicate = s -> {
            char ch = s.toLowerCase().charAt(0);
            return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
        };
        
        List<String> peoplesNames = people
                .stream()
                .map(person -> person.name + " " + person.lastName)
                .filter(vowelAtTheBeginningPredicate.negate())
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));

        peoplesNames.forEach(System.out::println);

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