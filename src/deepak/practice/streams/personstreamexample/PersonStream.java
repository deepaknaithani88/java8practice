package deepak.practice.streams.personstreamexample;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import deepak.practice.streams.personstreamexample.pojo.Person;

public class PersonStream {

	public static void main(String[] args) {
		List<String> firstNames = new ArrayList<>();
		List<Person> persons = createPersonsList();

		Stream<Person> stream = persons.stream();
		stream.forEach(s -> System.out.println(s));

		// stream = persons.stream();
		// stream.forEach(System.out::println);

		Consumer<String> c1 = s -> firstNames.add(s);
		Consumer<String> c1ReferenceMethodType = firstNames::add;

		Consumer<String> c2 = s -> System.out.println(s);
		Consumer<String> c2ReferenceMethodType = System.out::println;

		// persons.stream().forEach(c1.andThen(c2));
		Predicate<Person> personPredicate = p -> p.getAge() > 0;
		Stream<Person> filteredStream = persons.stream()
				.filter(personPredicate.negate());
		Stream<Person> filteredStream1 = persons.stream()
				.filter(personPredicate);

		System.out.println("Fitered with negate");
		filteredStream.forEach(System.out::println);
		System.out.println("\nFitered without negate");
		filteredStream1.forEach(System.out::println);

	}

	public static List<Person> createPersonsList() {
		List<Person> persons = new ArrayList<Person>();

		for (int i = 0; i < 1; i++) {
			Person person = new Person();
			person.setFirstName(i + " First\n");
			person.setLastName(i + " Last\n");
			person.setAge(i);
			persons.add(person);
		}

		return persons;
	}

}
