package chapter.two.q5;

import java.util.stream.Stream;

public class Five {
	
	private static long seed = 0L;
	private static long x = 0L;
	private static boolean firstRun = true;
	
	private static final long	a = 25214903917L;
	private static final int 	c = 11;
	private static final long 	m = 2^48L;
	// haha, ACM, get it?

	public static void main(String ... args) {
		Five.seed(17);
		
		System.out.println(Five.random());
		System.out.println(Five.random());
		System.out.println(Five.random());
		System.out.println(Five.random());
		System.out.println(Five.random());
		
		System.out.println("~~~~");
		
		Five.random(Five.seed, a, c, m).limit(5).forEach(System.out::println);
	}
	
	// stream way
	public static Stream<Long> random(long seed, long a, int c, long m) {
		return Stream.iterate(seed, x -> (a * x + c) % m);
	}
	
	// non-stream stateful way
	public static long random() {
		if (firstRun) {
			x = Five.seed;
			firstRun = false;
		} else {
			x = (a * x + c) % m;
		}
		return x;
	}
	
	public static void seed(long seed) {
		Five.seed = seed;
	}
	
}
