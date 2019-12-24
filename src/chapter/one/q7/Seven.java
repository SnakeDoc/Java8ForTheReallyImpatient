package chapter.one.q7;

public class Seven {

	public static void main(String ... args) {
		
		andThen(new MyRunnable("First running!"),
				new MyRunnable("Second Running!"))
			.run();
		
		andThen(() -> {System.out.println("Thirsd running!");},
				() -> {System.out.println("Fourth running!");})
			.run();
	}
	
	public static Runnable andThen(Runnable first, Runnable second) {
		return () -> {
			first.run();
			second.run();
		};
	}

	private static class MyRunnable implements Runnable {
		final String text;
		public MyRunnable(String text) { this.text = text; }
		@Override
		public void run() {
			System.out.println(text);
		}
	}
	
}
