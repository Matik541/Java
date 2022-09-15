package com.learn;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int limit = 6;
        Set<Integer> numbers = new HashSet<>();
        Random random = new Random();
        while (numbers.size() < limit)
            numbers.add(random.nextInt(10));

//      cheats:
//        for (int number : numbers)
//            System.out.print(number + ", ");


        System.out.println("\nGuess the numbers: ");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int guess = scanner.nextInt();
            if (numbers.contains(guess)) {
                System.out.println("You guessed a number!");
                numbers.remove(guess);
            }
            if (numbers.isEmpty()) {
                System.out.println("You guessed all numbers!");
                break;
            }
        }
    }
}