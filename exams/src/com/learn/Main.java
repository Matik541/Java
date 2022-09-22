package com.learn;

import java.util.*;

public class Main {
	public static void main(String[] args) {

		int[] random = fill_random(50);
		System.out.println(Arrays.toString(random));

		List<Integer> unique = unique_list(random);
		System.out.println(unique.toString());

		List<Integer> primes = primes_list(unique);
		System.out.println(primes.toString());

		int[] sequence = longest_sequence(random);
		System.out.println("\nLongest sequence: " + sequence.length);
		System.out.println(Arrays.toString(sequence));
	}

	/**
	 * Fill array with random numbers in <1, bound>
	 * @param bound highest value in range
	 * @return filled array
	 */
	public static int[] fill_random(int bound) {
		int[] random = new int[20];
		for (int i = 0; i < random.length; i++) {
			random[i] = (int) (Math.random() * bound + 1);
		}
		return random;
	}

	/**
	 * Create a List of unique numbers in array
	 * @param array array to get all unique values
	 * @return unique List
	 */
	public static List<Integer> unique_list(int[] array) {
		List<Integer> unique = new ArrayList<>();
		for (int num : array)
			if (!unique.contains(num))
				unique.add(num);
		return unique;
	}

	/**
	 * Display all primes number in Unique List
	 * @param list List of unique numbers
	 * @return List of primes
	 */
	public static List<Integer> primes_list(List<Integer> list) {
		List<Integer> primes = new ArrayList<>();
		for (int num : list) {
			boolean isPrime = true;
			for (int i = 2; i < num; i++) {
				if (num % i == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime)
				primes.add(num);
		}
		return primes;
	}

	/**
	 * Return array including the longest sequence of threatening number
	 * @param array array to be search
	 * @return array of the longest sequence
	 */
	public static int[] longest_sequence(int[] array) {
		int longest = 0;
		int longestStart = 0;
		int current = 1;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] < array[i+1]){
				current++;
				continue;
			}
			if (current > longest) {
				longest = current;
				longestStart = i - current;
			}
			current = 1;
		}
		int [] back = new int[longest];
		for (int i = longestStart+1; i < longestStart+longest+1; i++) {
			back[i-longestStart-1] = array[i];
		}
		return back;
	}
}