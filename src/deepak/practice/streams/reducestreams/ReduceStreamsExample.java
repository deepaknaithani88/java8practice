package deepak.practice.streams.reducestreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class ReduceStreamsExample {

	public static void main(String[] args) {
		Number id = 0;

		List<Number> list1 = new ArrayList<Number>();
		BinaryOperator<Number> sumOfEmptyStream = (i1, i2) -> i1.intValue()
				+ i2.intValue();
		System.out.println(list1.stream().reduce(id, sumOfEmptyStream));
		System.out.println(list1.stream().reduce(sumOfEmptyStream));

		List<Number> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		BinaryOperator<Number> sum = (i1, i2) -> i1.intValue() + i2.intValue();
		System.out.println(list2.stream().reduce(id, sum));
		System.out.println(list2.stream().reduce(sum));

		List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		BinaryOperator<Integer> max = (i1, i2) -> i1.intValue() > i2.intValue()
				? i1.intValue()
				: i2.intValue();
		System.out.println(list3.stream().max(Comparator.naturalOrder()));
		System.out.println(list3.stream().min(Comparator.naturalOrder()));
		// list3.stream().distinct().forEach(System.out::println);
		System.out.println(list3.stream().max(Integer::compareTo).get());
		Optional<Integer> optional = list3.stream()
				.max(Comparator.naturalOrder());
		if (optional.isPresent()) {
			System.out.println(optional.get());
		}
	}
}
