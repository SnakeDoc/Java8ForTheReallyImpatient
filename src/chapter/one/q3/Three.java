package chapter.one.q3;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;

public class Three {

	public static void main(String ... args) {
		Arrays.stream(solution("/", ".sys")).forEach(System.out::println);
	}
	
	private static File[] solution(String rootDirectory, String extension) {
		final File root = Paths.get(rootDirectory).toFile();
		return root.listFiles(file -> file.getName().endsWith(extension));
	}
	
}
