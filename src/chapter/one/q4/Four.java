package chapter.one.q4;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;

public class Four {

	public static void main(String ... args) {
		Arrays.stream(solution("/")).forEach(System.out::println);
	}
	
	private static File[] solution(String rootDirectory) {
		final File root = Paths.get(rootDirectory).toFile();
		final File[] files = root.listFiles();
		
		Arrays.sort(files, (first, second) -> {
			if (first.isDirectory() && !second.isDirectory()) {
				return -1;
			} else if (!first.isDirectory() && second.isDirectory()) {
				return 1;
			} else {
				return first.compareTo(second);
			}
		});
		
		return files;
	}
	
}
