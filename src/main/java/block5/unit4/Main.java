package block5.unit4;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static AtomicInteger three = new AtomicInteger();
    static AtomicInteger four = new AtomicInteger();
    static AtomicInteger five = new AtomicInteger();

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

    public static boolean beautifulWordAbba(String word) {

        char[] arr = word.toCharArray();

        for (int i = 0; i < Math.floorDiv(arr.length, 2); i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                return false;
            }
        }

        return true;
    }

    public static boolean beautifulWordAaa(String word) {

        char[] arr = word.toCharArray();

        char reference = arr[0];
        for (char c : arr) {
            if (c != reference) {
                return false;
            }
        }

        return true;
    }

    public static boolean beautifulWordAaCcc(String word) {

        char[] arr = word.toCharArray();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }

        return true;
    }

    public static void increment(String str) {
        switch (str.length()) {
            case 3:
                three.getAndIncrement();
                break;
            case 4:
                four.getAndIncrement();
                break;
            case 5:
                five.getAndIncrement();
                break;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }

        Thread threeLetter = new Thread(() -> {
            for (String str : texts) {
                if (beautifulWordAaa(str)) {
                    increment(str);
                }
            }
        });

        Thread fourLetter = new Thread(() -> {
            for (String str : texts) {
                if (beautifulWordAaCcc(str)) {
                    increment(str);
                }
            }
        });

        Thread fiveLetter = new Thread(() -> {
            for (String str : texts) {
                if (beautifulWordAbba(str)) {
                    increment(str);
                }
            }
        });

        threeLetter.start();
        fourLetter.start();
        fiveLetter.start();

        threeLetter.join();
        fourLetter.join();
        fiveLetter.join();

        System.out.println("Красивых слов с длиной 3: " + three.get() + " шт");
        System.out.println("Красивых слов с длиной 4: " + four.get() + " шт");
        System.out.println("Красивых слов с длиной 5: " + five.get() + " шт");
    }
}
