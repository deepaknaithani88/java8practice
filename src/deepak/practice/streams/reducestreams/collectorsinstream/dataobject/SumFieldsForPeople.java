package deepak.practice.streams.reducestreams.collectorsinstream.dataobject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import deepak.practice.streams.reducestreams.collectorsinstream.CollectorsExample;

public class SumFieldsForPeople {

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

		Map<Integer, List<Person>> map = persons.stream()
				.collect(Collectors.groupingBy(Person::getKeys));

		System.out.println(map + "\n");
	}
}
