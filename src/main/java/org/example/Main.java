package org.example;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);

        // ---------------------------- problem 01 -----------------------------//
        List<Integer> myNumbers = new ArrayList<>();
        myNumbers.add(1);
        myNumbers.add(2);
        myNumbers.add(3);
        myNumbers.add(4);
        myNumbers.add(5);

        System.out.println("Sum with for loop: " + sumWithForLoop(myNumbers));
        System.out.println("Sum with while loop: " + sumWithWhileLoop(myNumbers));
        System.out.println("Sum with recursion: " + sumWithRecursion(myNumbers));


        // ----------------------------- problem 02---------------------------------//

        List<String> listA = new ArrayList<>();
        listA.add("Apple");
        listA.add("Banana");
        listA.add("Cherry");

        List<String> listB = new ArrayList<>();
        listB.add("Dog");
        listB.add("Elephant");
        listB.add("Frog");
        listB.add("Giraffe");

        List<String> result1 = alternateCombine(listA, listB);
        System.out.println("Combined List 1: " + result1); // Expected: [Apple, Dog, Banana, Elephant, Cherry, Frog, Giraffe]

        List<Integer> listC = new ArrayList<>();
        listC.add(1);
        listC.add(3);

        List<Integer> listD = new ArrayList<>();
        listD.add(2);
        listD.add(4);
        listD.add(6);

        List<Integer> result2 = alternateCombine(listC, listD);
        System.out.println("Combined List 2: " + result2); // Expected: [1, 2, 3, 4, 6]


        // ------------------------ problem 03 ------------------//

        int count = 100;

        List<Long> first100Fibonacci = getFirstNFibonacciNumbers(count);

        System.out.println("First " + count + " Fibonacci Numbers:");
        for (int i = 0; i < first100Fibonacci.size(); i++) {
            System.out.println((i + 1) + ": " + first100Fibonacci.get(i));
        }


        // ---------------------------- problem 04 -------------------------//
        String largestPossibleNumber = largestNumber();
        System.out.println("Largest Possible Number: "+largestPossibleNumber);

    }


    // ----------------------------- Methods related to problem 01 --------------------------------//
    // Computes the sum of numbers in a list using a for loop.

    public static int sumWithForLoop(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }


    //Computes the sum of numbers in a list using a while loop.

    public static int sumWithWhileLoop(List<Integer> numbers) {
        int sum = 0;
        int i = 0;
        while (i < numbers.size()) {
            sum += numbers.get(i);
            i++;
        }
        return sum;
    }


    // Computes the sum of numbers in a list using recursion.
    //This is a helper function to initiate the recursive process.


    public static int sumWithRecursion(List<Integer> numbers) {
        return sumWithRecursionHelper(numbers, 0);
    }


    // Recursive helper function to compute the sum of numbers in a list.

    private static int sumWithRecursionHelper(List<Integer> numbers, int index) {
        // Base case: If the index is out of bounds, there are no more numbers to add.
        if (index >= numbers.size()) {
            return 0;
        }
        // Recursive step: Add the current number and the sum of the rest of the list.
        return numbers.get(index) + sumWithRecursionHelper(numbers, index + 1);
    }


// ----------------------------- Methods related to problem 02 --------------------------------//

    public static <T> List<T> alternateCombine(List<T> list1, List<T> list2) {
        List<T> combinedList = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < list1.size() || j < list2.size()) {
            if (i < list1.size()) {
                combinedList.add(list1.get(i));
                i++;
            }
            if (j < list2.size()) {
                combinedList.add(list2.get(j));
                j++;
            }
        }
        return combinedList;
    }


    // ----------------------------- Methods related to problem 03 --------------------------------//
    public static List<Long> getFirstNFibonacciNumbers(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number of Fibonacci numbers cannot be negative.");
        }

        List<Long> fibonacciList = new ArrayList<>();

        if (n >= 1) {
            fibonacciList.add(0L); // First Fibonacci number
        }
        if (n >= 2) {
            fibonacciList.add(1L); // Second Fibonacci number
        }

        for (int i = 2; i < n; i++) {
            long nextFib = fibonacciList.get(i - 1) + fibonacciList.get(i - 2);
            fibonacciList.add(nextFib);
        }

        return fibonacciList;
    }


    // ------------------------------- Methods related to problem 04 ------------------------------------------------------//

    public static String largestNumber() {

        int[] a = {50, 2, 1, 9};
        int len = a.length;
        String ch = "";
        List<Map<String, ArrayList<String>>> list_map = new ArrayList<Map<String, ArrayList<String>>>();
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < len; i++) {
            ch = "" + a[i];
            String str = "";
            ArrayList<String> arraylist = new ArrayList<String>();
            for (int j = 0; j < len; j++) {
                str = "" + a[j];
                if (ch.charAt(0) == str.charAt(0)) {
                    arraylist.add(str);
                    Collections.sort(arraylist);
                    map.put("" + ch.charAt(0), arraylist);
                }
            }
        }
        list_map.add(map);
        String str = "";
        for (String key : map.keySet()) {
            str = map.get(key) + str;

        }
        str = str.replaceAll("\\D+", "");
        //System.out.println(str);
        return str;
    }


}
