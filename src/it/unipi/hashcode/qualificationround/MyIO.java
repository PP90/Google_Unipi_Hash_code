package it.unipi.hashcode.qualificationround;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyIO {

	public static List<String> readInput(String inputFileName) throws IOException {

		List<String> lines = null;
		
		// read file into stream, try-with-resources
		Stream<String> stream = Files.lines(Paths.get(inputFileName));
		lines = stream.collect(Collectors.toList());// .forEach(System.out::println);
		// stream.close();
		
		// Example with new Java features
		// lines.forEach(System.out::println);
		
		return lines;
	}

	public static void writeOutput(String outputFileName, List<String> lines) throws IOException {
		Files.write(Paths.get(outputFileName), lines, Charset.defaultCharset());
	}
}
