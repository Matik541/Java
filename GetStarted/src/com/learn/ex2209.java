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
      fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];

    System.out.println(Arrays.toString(fibonacci));

    System.out.println("Enter the number to find nearest number from fibonnaci seqence: ");
    Scanner keyboard = new Scanner(System.in);
    int input = keyboard.nextInt();

    int index = Arrays.binarySearch(fibonacci, input);
    if (index < 0) {
      index = -index - 1;
      if (index == fibonacci.length)
        System.out.println("Nearest number is: " + fibonacci[index-1]);
      else if (index == 0)
        System.out.println("Nearest number is: " + fibonacci[index]);
      else {
        int left = fibonacci[index-1];
        int right = fibonacci[index];
        System.out.println("Nearest number is: " + ((input - left) < (right - input) ? left : right));
      }
    } else
      System.out.println("Nearest number is: " + fibonacci[index]);

    // 3.
    int[] random = new int[100];
    for (int i = 0; i < random.length; i++)
      random[i] = (int) (Math.random() * 100 + 1);
    System.out.println(Arrays.toString(random));

    List<Integer> evenList = new ArrayList<>();
    List<Integer> oddList = new ArrayList<>();
    for (int i = 0; i < random.length; i++) {
      if (random[i] % 2 == 0)
        evenList.add(random[i]);
      else
        oddList.add(random[i]);
    }

    List<Integer> uniqueList = new ArrayList<>();
    for (int i = 0; i < random.length; i++)
      if (!uniqueList.contains(random[i]))
        uniqueList.add(random[i]);

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
    System.out.println("Mediana: " + random[random.length/2]);

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