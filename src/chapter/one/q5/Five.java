package chapter.one.q5;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;

public class Five {

	public static void main(String ... args) {
		
		final File root = Paths.get("/").toFile();
		
		/* Runnable solution */
		final Runnable r1 = new Runnable() {
			@Override
			public void run() {
				final File[] files = root.listFiles();
				for (File file : files) {
					System.out.println(file);
				}
			}
		};
		r1.run();
		
		/* Lambda solution */
		final Runnable r2 = () -> Arrays.stream(root.listFiles()).forEach(System.out::println);
		r2.run();
		
	}
	
}
