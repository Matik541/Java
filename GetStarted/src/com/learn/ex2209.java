package com.learn;

import java.util.*;

public class ex2209 {
  public static void main(String[] args) {

    // 1.
    double[] array = new double[10];
    for (int i = 0; i < array.length; i++)
      array[i] = Math.sqrt(i);

    System.out.println(Arrays.toString(array));

    // 2.
    int[] fibonacci = new int[40];
    fibonacci[0] = 0;
    fibonacci[1] = 1;
    for (int i = 2; i < fibonacci.length; i++)
      fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];

    System.out.println(Arrays.toString(fibonacci));

    System.out.println("Enter the number to find nearest number from fibonnaci seqence: ");
    Scanner keyboard = new Scanner(System.in);
    int input = keyboard.nextInt();

    int left = 0;
    int right = fibonacci.length;
    int middle = (left + right) / 2;
    while (left <= right) {
      if (right == left) {
        if (Math.abs(fibonacci[middle - 1] - input) < Math.abs(fibonacci[middle] - input))
          middle = middle - 1;
        break;
      }
      if (fibonacci[middle] < input)
        left = middle + 1;
      else if (fibonacci[middle] == input) {
        System.out.println("The number is in the sequence");
        break;
      } else
        right = middle - 1;
      middle = (left + right) / 2;
    }
    System.out.println("The nearest number is " + fibonacci[middle]);

    // 3.
    int[] random = new int[100];
    for (int i = 0; i < random.length; i++)
      random[i] = (int) (Math.random() * 100 + 1);
    System.out.println(Arrays.toString(random));

    List<Integer> evenList = new ArrayList<>();
    List<Integer> oddList = new ArrayList<>();
    for (int k : random) {
      if (k % 2 == 0)
        evenList.add(k);
      else
        oddList.add(k);
    }

    Set<Integer> uniqueList = new HashSet<>();
    for (int k : random)
      uniqueList.add(k);

    System.out.println("Even numbers: " + evenList);
    System.out.println("Odd numbers: " + oddList);
    System.out.println("Unique numbers: " + uniqueList);
    System.out.println("Count of unique numbers: " + uniqueList.size());

    // 4.
    Arrays.sort(random);
    System.out.println("Sorted array: " + Arrays.toString(random));
    double avg = 0;
    for (int j : random)
      avg += j;
    avg /= random.length;
    System.out.println("Average: " + avg);
    System.out.println("Mediana: " + random[random.length / 2]);

    Map<Integer, Integer> frequency = new HashMap<>();
    for (int value : random) {
      if (frequency.containsKey(value))
        frequency.put(value, frequency.get(value) + 1);
      else
        frequency.put(value, 1);
    }
    int max = 0;
    for (int value : frequency.values())
      if (value > max)
        max = value;

    System.out.println("Dominant: " + max);


    // 5.
    boolean[] primaryArray = new boolean[1000];
    Arrays.fill(primaryArray, true);
    for (int i = 2; i < Math.sqrt(primaryArray.length); i++)
      if (primaryArray[i])
        for (int j = i * i; j < primaryArray.length; j += i)
          primaryArray[j] = false;

    System.out.println("Enter the starting number: ");
    int start = keyboard.nextInt();
    System.out.println("Enter the ending number: ");
    int end = keyboard.nextInt();
    for (int i = start; i <= end; i++)
      if (primaryArray[i])
        System.out.print(i + " ");
  }
}