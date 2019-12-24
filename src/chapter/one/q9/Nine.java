package chapter.one.q9;

import java.util.Arrays;

public class Nine {

	public static void main(String ... args) {
		
		final Collection2<String> c2 = new ArrayList2<>();
		String[] names = { "James", "John", "Jim", "Jason" };
		c2.addAll(Arrays.asList(names));
		
		c2.forEachIf(System.out::println, e -> e.contains("a"));
	}
	
}
