package chapter.two.q2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Two {

	public static void main(String ... args) throws IOException {
		final String contents = new String(Files.readAllBytes(
				Paths.get("./src/WarAndPeace-3Times.txt")), StandardCharsets.UTF_8);
		final List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		
		System.out.println(runTest(words));
	}
	
	private static long runTest(List<String> words) {
		int[] filterRunCount = new int[1];
		return words.stream().filter(w -> {
			System.out.println("Filter is called " + (++filterRunCount[0]) 
					+ " times - examining word with length " + w.length());
			return w.length() > 12;
		}).limit(5).count();
	}
	
}
