package deepak.practice.streams.streamofstrings;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class StringStream {
	public static void main(String[] args) {
		Stream<String> stream1 = Stream.of("one", "two", "three", "four",
				"five");
		Predicate<String> stream1Predicate1 = s -> s.length() > 3;

		Predicate<String> stream1Predicate2 = Predicate.isEqual("two");
		// s -> s.equals("two");

		stream1.filter(stream1Predicate1.or(stream1Predicate2))
				.forEach(System.out::println);
	}
}
