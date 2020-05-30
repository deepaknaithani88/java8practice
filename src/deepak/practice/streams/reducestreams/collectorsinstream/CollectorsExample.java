package deepak.practice.streams.reducestreams.collectorsinstream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import deepak.practice.streams.reducestreams.collectorsinstream.dataobject.Person;

public class CollectorsExample {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				CollectorsExample.class.getResourceAsStream(
						"/deepak/practice/streams/reducestreams/collectorsinstream/people.txt")));
				Stream<String> stream = reader.lines();) {
			System.out.println(stream.map(line -> {
				String[] s = line.split(",");
				Person p = new Person(s[0].trim(), Integer.parseInt(s[1]));
				p.setField1(Integer.parseInt(s[2]));
				p.setField2(Integer.parseInt(s[3]));
				p.setField3(Integer.parseInt(s[4]));
				p.setField4(Integer.parseInt(s[5]));
				persons.add(p);
				return p;
			}).count());
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("\nSecond Stream:::");
		Stream<Person> personStream = persons.stream();

		personStream.filter(p -> p.getAge() >= 20)
				.forEach(s -> System.out.println(s));

		Optional<Person> optMinPerson = persons.stream()
				.filter(p -> p.getAge() >= 20)
				.min(Comparator.comparing(Person::getAge));

		Optional<Person> optMaxPerson = persons.stream()
				.filter(p -> p.getAge() >= 20)
				.max(Comparator.comparing(Person::getAge));

		System.out.println(optMinPerson + "\n");
		System.out.println(optMaxPerson + "\n");

		Map<Integer, List<Person>> map1 = persons.stream()
				.collect(Collectors.groupingBy(Person::getAge));
		Map<Integer, Long> map2 = persons.stream().collect(
				Collectors.groupingBy(Person::getAge, Collectors.counting()));

		Map<Integer, List<String>> map3 = persons.stream()
				.collect(Collectors.groupingBy(Person::getAge, Collectors
						.mapping(Person::getName, Collectors.toList())));

		Map<Integer, Set<String>> map4 = persons.stream()
				.collect(Collectors.groupingBy(Person::getAge,
						Collectors.mapping(Person::getName,
								Collectors.toCollection(TreeSet::new))));

		Map<Integer, String> map5 = persons.stream()
				.collect(Collectors.groupingBy(Person::getAge, Collectors
						.mapping(Person::getName, Collectors.joining(" "))));

		Map<Integer, Integer> map6 = persons.stream()
				.collect(Collectors.groupingBy(Person::getAge,
						Collectors.summingInt(Person::getAge)));

		Map<Integer, List<Person>> map7 = persons.stream()
				.collect(Collectors.groupingBy(Person::getKeys));

		System.out.println(map1 + "\n");
		System.out.println(map2 + "\n");
		System.out.println(map3 + "\n");
		System.out.println(map4 + "\n");
		System.out.println(map5 + "\n");
		System.out.println(map6 + "\n");
		System.out.println(map7 + "\n");

	}

}
