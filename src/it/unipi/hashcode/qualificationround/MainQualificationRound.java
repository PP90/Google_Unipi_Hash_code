package it.unipi.hashcode.qualificationround;

import java.io.IOException;
import java.util.List;

public class MainQualificationRound {

	public static void main(String[] args){
		String inputFileName = "C:\\Users\\Alessio\\Documents\\GitHub\\Google_Painting\\logo.in";
		String outputFileName = "C:\\Users\\Alessio\\Documents\\GitHub\\Google_Painting\\logoCoded.out";
		
		try {
			List<String> readInput = MyIO.readInput(inputFileName);
			readInput.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
