package com.learn;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		int limit = 10;
		int nums = 6;
		int bound = 10;

		Set<Integer> numbers = setRandom(nums, bound);
		System.out.printf("Bet your numbers (%d): \n", limit);
		List<Integer> guesses = guessesList(limit);
		List<Integer> correct = correctGuesses(numbers, guesses);
		Collections.sort(guesses);
		Collections.sort(correct);
		System.out.println("You bet on: " + guesses + "\nYou guessed correctly: " + correct + "\nYou guessed " + correct.size() + " numbers correctly");
	}

	public static Set<Integer> setRandom(int size, int bound) {
		Set<Integer> numbers = new HashSet<>();
		Random random = new Random();
		while (numbers.size() < size)
			numbers.add(random.nextInt(bound));

		return numbers;
	}

	public static List<Integer> guessesList(int limit) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> guesses = new ArrayList<>();
		while (guesses.size() < limit) {
			int guess = scanner.nextInt();
			if (guesses.contains(guess)) {
				System.out.println("You already guessed that number!");
				continue;
			}
			guesses.add(guess);
		}

		return guesses;
	}

	public static List<Integer> correctGuesses(Set<Integer> numbers, List<Integer> guesses) {
		List<Integer> summary = new ArrayList<>();

		for (int guess : guesses)
			if (numbers.contains(guess))
				summary.add(guess);

		return summary;
	}

}