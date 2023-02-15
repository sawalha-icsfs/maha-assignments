package day_2_practice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

public class ArrayRandom {

	private static Scanner scanner;

	private static List<Integer> mostFreqNumList = new ArrayList<Integer>();

	public static Integer findKey(HashMap<Integer, Integer> map, int value) {
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == value) {
				if (mostFreqNumList.contains(entry.getKey())) {
					continue;
				} else {
					return entry.getKey();
				}
			}
		}
		return null;
	}

	/* Get Most frequent three numbers */
	public static List<Integer> mostFrequent(int arr[]) {
		int inpArray[] = arr;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inpArray.length; i++) {
			int count = 0;// value
			for (int j = 0; j < inpArray.length; j++) {
				if (inpArray[i] == inpArray[j]) {
					count++;
				}
			}

			if (count > 1) {
				map.put(inpArray[i], count);
			}
		}
		List<Integer> FreqNumList = new ArrayList<Integer>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			FreqNumList.add(entry.getValue());
		}
		Collections.sort(FreqNumList);
		mostFreqNumList.add(findKey(map, FreqNumList.get(FreqNumList.size() - 1)));
		mostFreqNumList.add(findKey(map, FreqNumList.get(FreqNumList.size() - 2)));
		mostFreqNumList.add(findKey(map, FreqNumList.get(FreqNumList.size() - 3)));
		return mostFreqNumList;
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Please enter integer number greater than 10,000");
		scanner = new java.util.Scanner(System.in);

		int input = scanner.nextInt();
		while (input <= 10000) {
			System.out.println("Please enter integer number greater than 10,000");
			scanner = new java.util.Scanner(System.in);
			input = scanner.nextInt();
		}
		int[] randomArr = new int[input];
		Random randNumber = new Random();
		int result;
		int sum = 0;
		double avg = 0;
		File myObj = new File("D:/ArrayData.txt");

		FileWriter file = new FileWriter(myObj);
		if (myObj.createNewFile()) {
			System.out.println("File created: " + myObj.getName());
		} else {
			System.out.println("File already exists.");
		}
		/* To Write in file and find the summation */
		for (int i = 0; i < randomArr.length; i++) {
			result = randNumber.nextInt(1000);
			randomArr[i] = result;
			file.write(randomArr[i] + "\n");
			sum += randomArr[i];
		}
		file.close();

		avg = sum / input;
		System.out.println("summation = " + sum);
		System.out.println("Average = " + avg);
		List<Integer> resultList = mostFrequent(randomArr);
		System.out.println("Most frequent three numbers : "+ resultList);
	}
}
