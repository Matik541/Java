package com.learn;

import static com.learn.ex1509.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {

//          Guess a number :D
        System.out.println("choose the difficulty level: \n1. Easy 5 numbers \n2. Medium 10 numbers \n3. Hard 15 numbers \n4. Impossible 20 numbers ");
        Scanner scans = new Scanner(System.in);
        int input = ((scans.nextInt()-1)%4+1);
        int number = 5 * input;

        int[] numbers = new int[number];
        for (int i = 0; i < number; i++) {
            numbers[i] = random();
        }
//          <0;1) * 100 + 1 => <1;100>
//          int => double - exchange 4b to 8b
//          double => int - cut 8b to 4b
//          simple types: boolean, byte, short, int, long, float, double, char

        System.out.println(Arrays.toString(numbers));

        int [] bets = new int[number];

        System.out.println("bet on numbers: ");
        for (int i = 0; i < number; i++) {
            int newBet = scans.nextInt();
            bets[i] = newBet;
        }
        System.out.println();

        if (number == input)
            System.out.println("You guessed the right number, " + input + "!");
        else {
            System.out.println("Bad luck, You're wrong");
//          condition?true:false
//          switch () { case 1: break; }
//          switch () { case 1 -> ""; }
        }
    }
    public static int random() {
        return (int) (Math.random() * 100 + 1);
    }
}