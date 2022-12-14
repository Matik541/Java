package com.learn;

import java.util.*;

public class ex1509 { // exercise 15.09
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    System.out.println("\nAll even two digit numbers");
    displayEven(" ");

    System.out.println("\n\nCheck if word is palindrome");
    String word = keyboard.nextLine();
    System.out.print(
      checkPalindrome(word) ?
        word + " is a palindrome" :
        word + " isn't a palindrome, reverse of that word is: " + reverseString(word)
    );

    System.out.println("\n\nFind nearest palindrome number");
    int number = keyboard.nextInt();
    System.out.println("Nearest palindrome is: " + nearestPalindromeNumber(number));
    System.out.print("\nText to code with key 3: ");
    String text = keyboard.next();  // next() instead of nextLine() because of bug
    text += keyboard.nextLine();    // read the rest of the line
    System.out.println("Code: " + caesarCode(text, 3));

    System.out.println("\nCheck if two words are anagrams");
    System.out.print("first word: ");
    String word1 = keyboard.nextLine();
    System.out.print("second word: ");
    String word2 = keyboard.nextLine();
    System.out.println(
      checkAnagrams(word1, word2) ?
        word1 + " and " + word2 + " are anagrams" :
        word1 + " and " + word2 + " are NOT anagrams"
    );

    System.out.println("\nSum of factorials of digits in a number");
    int digits = keyboard.nextInt();
    System.out.println("Sum of factorials of digits in " + digits + " is: " + sumFactorials(digits));

    System.out.println("\nCheck if a number is prime");
    int prime = keyboard.nextInt();
    System.out.println(
      (checkPrime(prime)) ?
        prime + " is a prime number" :
        prime + " isn't a prime number"
    );

    System.out.println("\nYour generated password is: ");
    System.out.println(generatePassword(20, true, true, true));
  }


  /**
   * Display all even two-digit numbers separated by space.
   */
  public static void displayEven(String separator) {
//  Zadanie 1.
//  Wypisz na ekranie wszystkie liczby dodatnie dwucyfrowe parzyste. Liczby oddziel znakiem spacji.
    for (int i = 10; i < 99; i += 2)
      System.out.print(i + separator);
  }

  /**
   * Check if word is palindrome.
   * Same word when read from left to right and from right to left.
   *
   * @param word word to check
   * @return true if word is palindrome
   */
  public static boolean checkPalindrome(String word) {
//  Zadanie 2.
//  Wczytaj s??owo z klawiatury i sprawd??, czy jest palindromem, czyli czytane od pocz??tku do ko??ca i od ko??ca do pocz??tku ma takie samo brzmienie.
    String palindrome = reverseString(word);

    return word.equals(palindrome);
  }

  /**
   * Reverse string.
   *
   * @param text text to reverse
   * @return reversed string
   * @example reverseString("abc") -> "cba"
   */
  public static String reverseString(String text) {
    StringBuilder reverse = new StringBuilder();
    for (int i = text.length() - 1; i >= 0; i--)
      reverse.append(text.charAt(i));
    return reverse.toString();
  }

  /**
   * Find the nearest palindrome number.
   *
   * @param number base for the palindrome
   * @return nearest palindrome number
   * @example nearestPalindromeNumber(123) -> 121
   */
  public static int nearestPalindromeNumber(int number) {
//  Zadanie 3.
//  Znajd?? dla danej liczby najbli??sz?? jej liczb?? palindromiczn?? (czytana od pocz??tku jest taka sama jak czytana od ko??ca). Dla liczby 1015 najbli??sz?? liczb?? palindromiczn?? jest liczba 1001.
    number = Math.abs(number);
    if (number < 10) {
      return number;
    }
    int halfNum = (int) (number / (Math.pow(10, Integer.parseInt((number + "").length() / 2 + ""))));
    int leftHalf = ((number + "").length() % 2 == 0) ? halfNum : halfNum / 10;

    int normal = Integer.parseInt(
      leftHalf + reverseString((halfNum + ""))
    );
    int greater = Integer.parseInt(
      leftHalf + 1 + reverseString((halfNum + 1 + ""))
    );

    return (number - normal < greater - number) ?
      normal :
      greater;
  }

  /**
   * Caesar code - shift letters by key.
   *
   * @param text text to code/shift by key
   * @param key  key for the code
   * @return coded text
   * @example caesarCode("abYZ1!", 3) -> "deBC4!"
   */
  public static String caesarCode(String text, int key) {
//  Zadanie 4.
//  Wczytaj s??owo z klawiatury i zaszyfruj je szyfrem Cezara z kluczem 3. Szyfr Cezara polega na przesuni??ciu ka??dej litery alfabetu w prawo o klucz.
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < text.length(); i++) {
      int code = (text.charAt(i));

      if (code > 47 && code <= 57)
        code = ((code - 47 + key) % 10) + 47;
      if (code > 64 && code <= 90)
        code = ((code - 64 + key) % 26) + 64;
      if (code > 96 && code <= 122)
        code = ((code - 96 + key) % 26) + 96;

      result.append((char) (code));
    }

    return result.toString();
  }

  /**
   * Check if two words are anagrams.
   *
   * @param word1 first word to check
   * @param word2 second word to check
   * @return true if words are anagrams
   * @example checkAnagrams("abc", "cba") -> true
   */
  public static boolean checkAnagrams(String word1, String word2) {
//  Zadanie 5.
//  Wczytaj dwa s??owa i sprawd??, czy s?? one dla siebie anagramami, czyli sk??adaj?? si?? z tych samych liter w takiej samej liczbie.
    return Objects.equals(numOfLetters(word1).toString(), numOfLetters(word2).toString());
  }

  /**
   * Count frequency of letters in a word.
   *
   * @param word word to count letters
   * @return map of letters and their frequency
   * @example numOfLetters("abbc") -> {a=1, b=2, c=1}
   */
  public static Map<Character, Integer> numOfLetters(String word) {
    char[] wordsChar = word.toCharArray();
    Map<Character, Integer> letterMap = new HashMap<>();

    for (char letter : wordsChar) {
      Integer freq = letterMap.get(letter);
      letterMap.put(letter, (freq == null) ? 1 : freq + 1);
    }

    return letterMap;
  }

  /**
   * Calculate a sum of factorials form digits of a number.
   *
   * @param number number to slice to digits and calculate sum
   * @return sum of factorials
   */
  public static int sumFactorials(int number) {
//  Zadanie 6.
//  Napisz program obliczaj??cy sum?? silni cyfr z liczby.
    number = Math.abs(number);
    String[] digits = (number + "").split("");
    int sum = 0;

    for (String num : digits) {
      sum += factorial(Integer.parseInt(num));
    }

    return sum;
  }

  /**
   * Calculate factorial of a number.
   *
   * @param number number to calculate factorial
   * @return factorial of a number
   */
  public static int factorial(int number) {
    int result = 1;
    for (int i = 1; i <= number; i++)
      result *= i;
    return result;
  }

  /**
   * Check if a number is a prime number.
   *
   * @param number number to check
   * @return true if number is prime
   */
  public static boolean checkPrime(int number) {
//  Zadanie 7.
//  Sprawd??, czy liczba jest liczb?? pierwsz??, czyli ma dok??adnie dwa dzielniki: 1 i sam?? siebie.
    boolean isPrime = true;
    for (int i = 2; i < Math.sqrt(number); i++)
      if (number % i == 0) {
        isPrime = false;
        break;
      }
    return isPrime;
  }

  /**
   * Generate a random (using java.util.Random) password with given length form preSet of characters with possible numbers and special characters.
   *
   * @param length          length of the password
   * @param hasNumbers      if password should contain numbers
   * @param hasUpperCase    if password should contain upper case letters
   * @param hasSpecialChars if password should contain special characters
   * @return generated password
   */
  public static String generatePassword(int length, boolean hasNumbers, boolean hasUpperCase, boolean hasSpecialChars) {
//  Zadanie 8.
//  Wygeneruj has??o losowe. D??ugo???? has??a powinna wynosi?? 20 znak??w, a ponadto powinno zawiera?? liczby, wielkie i ma??e litery oraz znaki specjalne.
    String preSet = "abcdefghijklmnopqrstuvwxyz";
    preSet += (hasNumbers) ? "0123456789" : "";
    preSet += (hasUpperCase) ? "ABCDEFGHIJKLMNOPQRSTUVWXYZ" : "";
    preSet += (hasSpecialChars) ? "!@#$%^&*_=+-/.?<>)" : "";

    Random random = new Random();
    StringBuilder password = new StringBuilder(length);

    for (int i = 0; i < length; i++)
      password.append(preSet.charAt(random.nextInt(preSet.length())));

    return password.toString();
  }
}