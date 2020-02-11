package chapter.two.q4;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Four {

	public static void main(String ... args) {
		int[] values = { 1, 4, 9, 16 };

		Stream<int[]> intArrayStream = Stream.of(values);
		
		IntStream intStream = IntStream.of(values);
	}
	
}
