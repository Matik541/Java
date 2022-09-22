package com.learn;

import java.util.*;

public class Main {
	public static void main(String[] args) {

		int[] random = fill_random(50);
		System.out.println("Random: " + Arrays.toString(random));

		Set<Integer> unique = unique_set(random);
		System.out.println("Unique: " + unique.toString());

		List<Integer> primes = primes_list(unique, true);
		System.out.println("Primes: " + primes.toString());

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
	public static Set<Integer> unique_set(int[] array) {
		Set<Integer> unique = new HashSet<>();
		for (int k : array)
			unique.add(k);

		return unique;
	}

	/**
	 * Create an Erastotenes sieve of primes up to range
	 * @param range range of numbers to check
	 * @return List of prime numbers
	 */
	public static List<Integer> erastotenes_list(int range) {
		boolean[] sieve = new boolean[range + 1];
		Arrays.fill(sieve, true);
		sieve[0] = false;
		sieve[1] = false;

		for (int i = 2; i < sieve.length; i++)
			if (sieve[i])
				for (int j = i * i; j < sieve.length; j += i)
					sieve[j] = false;

		List<Integer> primes = new ArrayList<>();
		for (int i = 0; i < sieve.length; i++)
			if (sieve[i])
				primes.add(i);
		return primes;
	}

	/**
	 * List of prime numbers in set
	 * @param list List of unique numbers
	 * @return List of primes
	 */
	public static List<Integer> primes_list(Set<Integer> list, boolean sort) {
		List<Integer> sieve = erastotenes_list(50);
		List<Integer> primes = new ArrayList<>();
		for (int i : list) {
			if (sieve.contains(i)) {
				primes.add(i);
			}
		}
		if (sort)
			Collections.sort(primes);
		return primes;
	}

	/**
	 * Return array including the longest sequence of threatening number
	 * @param array array to be search
	 * @return array of the longest sequence
	 */
	public static int[] longest_sequence(int[] array) {
		/*
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
    */

		List<Integer> sequence = new ArrayList<>();
		sequence.add(1);
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[i - 1]) {
				sequence.add(sequence.get(i - 1) + 1);
			} else {
				sequence.add(1);
			}
		}

		int max = Collections.max(sequence);
		int index = sequence.indexOf(max);

		return Arrays.copyOfRange(array, index - max + 1, index + 1);
	}
}