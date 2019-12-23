package chapter.one.q2;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;

public class Two {

	public static void main(String ... args) {
		final String rootDirectory = "/";
		
		Arrays.stream(solutionOne(rootDirectory)).forEach(System.out::println);
		Arrays.stream(solutionTwo(rootDirectory)).forEach(System.out::println);
	}
	
	private static File[] solutionOne(String rootDirectory) {
		final File root = Paths.get(rootDirectory).toFile();
		return root.listFiles(file -> file.isDirectory());
	}
	
	
	/**
	 * Same as {@link #solutionOne(String)}, but uses a 
	 * 	method reference expression.
	 */
	private static File[] solutionTwo(String rootDirectory) {
		final File root = Paths.get(rootDirectory).toFile();
		return root.listFiles(File::isDirectory);
	}
	
}
