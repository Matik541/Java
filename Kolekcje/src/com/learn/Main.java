package com.learn;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int limit = 10;
        int nums = 6;
        int bound = 10;

        Set<Integer> numbers = new HashSet<>();
        Random random = new Random();
        while (numbers.size() < nums)
            numbers.add(random.nextInt(bound));

//      cheats:
//        for (int number : numbers)
//            System.out.print(number + ", ");

//        System.out.println(numbers);

        System.out.println("\nGuess the numbers: ");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Guesses left: " + (limit--) + " | Enter a number: ");
            int guess = scanner.nextInt();
            if (numbers.contains(guess)) {
                System.out.println("You guessed a number!");
                numbers.remove(guess);
            } else
                System.out.println("Wrong guess!");

            if (numbers.isEmpty()) {
                System.out.println("\nYou guessed all numbers! You won!");
                break;
            }
            if (limit <= 0) {
                System.out.println("\nYou run out of guesses! You lost!");
                break;
            }
        }
    }
}