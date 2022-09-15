package com.learn;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		int limit = 10;
		int nums = 6;
		int bound = 10;

		Set<Integer> numbers = new HashSet<>();
		Random random = new Random();
		while (numbers.size() < nums)
			numbers.add(random.nextInt(bound));

//		cheats:
//		for (int number : numbers)
//			System.out.print(number + ", ");

		System.out.println(numbers);

		System.out.println("\nGuess the numbers: ");
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> guesses = new ArrayList<>();
		ArrayList<Integer> guessed = new ArrayList<>();

		while (true) {
			System.out.print("Guesses left: " + (limit--) + " | Enter a number: ");
			int guess = scanner.nextInt();

			if (guesses.contains(guess) && guesses.size() > 0) {
				System.out.println("You already guessed that number!");
				limit++;
				continue;
			}
			guesses.add(guess);

			if (numbers.contains(guess)) {
				System.out.println("You guessed a number!");
				guessed.add(guess);
				numbers.remove(guess);
			} else
				System.out.println("Wrong guess!");

			if (numbers.isEmpty()) {
				System.out.println("\nYou guessed all numbers! You won!\n" + guessed);
				break;
			}
			if (limit <= 0) {
				System.out.println("\nYou run out of guesses! You lost!\nBut you guessed " + guessed.size() + " numbers!\n" + guessed);
				break;
			}
			// display  guesses
		}
	}
}