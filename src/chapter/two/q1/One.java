package chapter.two.q1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class One {

	public static void main(String ... args) throws IOException {
		final String contents = new String(Files.readAllBytes(
				Paths.get("./src/WarAndPeace-3Times.txt")), StandardCharsets.UTF_8);
		final List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		
		for (int i = 0; i < 50; i++) {
			runTest(words);
		}
	}
	
	public static void runTest(List<String> words) {
		
		final long streamStart = System.currentTimeMillis();
		final long streamCount = words.stream().filter(w -> w.length() > 12).count();
		final long streamStop = System.currentTimeMillis();
		
		final long parallelStreamStart = System.currentTimeMillis();
		final long parallelStreamCount = words.parallelStream().filter(w -> w.length() > 12).count();
		final long parallelStreamStop = System.currentTimeMillis();
		
		// the loop we're replacing outside a parallel stream
//		int count = 0;
//		for (String w : words) {
//			if (w.length() > 12) count++;
//		}
		
		final long threadStart = System.currentTimeMillis();
		
		final int cpus = Runtime.getRuntime().availableProcessors();
		
		int pos = 0;
		//final int[] counter = new int[cpus];
		final AtomicInteger threadCount = new AtomicInteger(0); // cheat and use a single counter variable... cuz...
		final Thread[] runners = new Thread[cpus];
		for (int i = 0; i < cpus; i++) {
			final int threadNumber = i;
			final int runnerLength = i < cpus - 1 ? words.size() / cpus : (words.size() / cpus) + (words.size() % cpus);
			final List<String> runnerWords = words.subList(pos, pos + runnerLength);
			pos += runnerLength;

			final Thread runner = new Thread() {
				@Override
				public void run() {
					for (String word : runnerWords) {
						if (word.length() > 12) {
							//counter[threadNumber]++; use the atomic integer instead
							threadCount.incrementAndGet();
						}
					}
				}
			};
			runners[threadNumber] = runner;
			runner.start();
		}
		
		for (Thread runner : runners) {
			try {
				runner.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
//		int threadCountTotal = 0; // no need to sum the counters now
//		for (int threadCount : counter) {
//			threadCountTotal += threadCount;
//		}
		
		final long threadStop = System.currentTimeMillis();
		
		System.out.println("Stream Word Count: " + streamCount + " in " + (streamStop - streamStart) + " milliseconds");
		System.out.println("Parallel Stream Word Count: " + parallelStreamCount + " in " + (parallelStreamStop - parallelStreamStart) + " milliseconds");
		System.out.println("Parallel Thread Word Count: " + threadCount.get() /* threadCountTotal */ + " in " + (threadStop - threadStart) + " milliseconds");
	}
	
}
