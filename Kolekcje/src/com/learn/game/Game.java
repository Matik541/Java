package com.learn.game;

import java.util.*;

public class Game {
	/*
	Acces info:
	none - allow everywere in package
	public - allow everywere
	private - allow only in class
	protected - allow in package and in subclasses
	 */
	private int price = 1000000;
	private int rNums = 10;
	private static Set<Integer> numbers = new HashSet<>();
	private List<Integer> guesses = new ArrayList<>();
	private List<Integer> correct = new ArrayList<>();

	public Game(int price, int randomNumbers, int bound, int limit) {
		this.price = price;
		this.rNums = randomNumbers;
		setRandom(randomNumbers, bound);
		guesses(limit);
		correctGuesses();
	}

	private static void setRandom(int size, int bound) {
		Random random = new Random();
		while (numbers.size() < size)
			numbers.add(random.nextInt(bound));
	}

	private void guesses(int limit) {
		System.out.printf("Bet your numbers (%d): \n", limit);
		Scanner scanner = new Scanner(System.in);
		guesses.clear();

		while (guesses.size() < limit) {
			int guess = scanner.nextInt();
			if (guesses.contains(guess)) {
				System.out.println("You already guessed that number!");
				continue;
			}
			guesses.add(guess);
		}
	}

	private void correctGuesses() {
		for (int guess : guesses)
			if (numbers.contains(guess))
				correct.add(guess);

		System.out.println(
						"You bet on: " + guesses + "\n" +
										"You guessed correctly: " + correct + "\n" +
										"You guessed " + correct.size() + " numbers correctly\n" +
										"You won: " + ((double) (correct.size() / rNums) * price) + " $"
		);
	}
}
