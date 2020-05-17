package deepak.practice.streams.reducestreams;

import java.util.Arrays;
import java.util.List;

public class ReduceStreamsExample1 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(-5, -10);

		// sum
		System.out.println(list.stream().reduce(-10, Integer::sum));
		System.out.println(list.stream().reduce(0, Integer::sum));
		System.out.println(list.stream().reduce(10, Integer::sum));

		// max
		System.out.println(list.stream().reduce(-10, Integer::max));
		System.out.println(list.stream().reduce(0, Integer::max));
		System.out.println(list.stream().reduce(10, Integer::max));

		System.out.println(list.stream().reduce(Integer::max));
		System.out.println(list.stream().reduce(Integer::max));
		System.out.println(list.stream().reduce(Integer::max));

	}
}
