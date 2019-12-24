package chapter.one.q6;

public class Six {

	public static void main(String ... args) {
		new Thread(uncheck(
				() -> { System.out.println("Zzz"); Thread.sleep(1000); })).start();	
	}
	
	public static Runnable uncheck(RunnableEx runner) {
		return () -> {
			try {
				runner.run();
			} catch (Exception e) {
				// convert checked exception into 
				// 	unchecked exception and throw
				throw new RuntimeException(e);
			}
		};
	}
	
}

@FunctionalInterface
interface RunnableEx {
	public void run() throws Exception;
}
