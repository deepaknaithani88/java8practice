package deepak.practice.streams.streamofstrings;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamStringPeek {
	public static void main(String[] args) {
		List<String> result = new ArrayList<>();

		Stream<String> stream1 = Stream.of("one", "two", "three", "four",
				"five");
		Predicate<String> stream1Predicate1 = s -> s.length() > 3;

		Predicate<String> stream1Predicate2 = Predicate.isEqual("two");
		// s -> s.equals("two");

		stream1.peek(System.out::println)
				.filter(stream1Predicate1.or(stream1Predicate2))
				.forEach(result::add);

		System.out.println();
		System.out.println(result);
		Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3)
				.peek(e -> System.out.println("Filtered value: " + e))
				.map(String::toUpperCase)
				.peek(e -> System.out.println("Mapped value: " + e))
				.collect(Collectors.toList());
	}
}
