package block5.unit2.task1;

import java.util.*;

public class Main {

    public static final Map<Integer, Integer> sizeToFreq = new TreeMap<>();

    public static String generateRoute(String letters, int length) {
        Random random = new Random();
        StringBuilder route = new StringBuilder();
        for (int i = 0; i < length; i++) {
            route.append(letters.charAt(random.nextInt(letters.length())));
        }
        return route.toString();
    }

    public static void main(String[] args) throws InterruptedException {

        Thread output = new Thread(
                () -> {
                    synchronized (sizeToFreq) {
                        while (!Thread.interrupted()) {
                            try {
                                sizeToFreq.wait();
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                            int maxCountR = 0;
                            int numberR = 0;
                            for (Integer countR : sizeToFreq.keySet()) {
                                if (maxCountR < sizeToFreq.get(countR)) {
                                    maxCountR = sizeToFreq.get(countR);
                                    numberR = countR;
                                }
                            }
                            System.out.println("текущий лидер среди частот - " + numberR + " (встретилось " + maxCountR + " раз)");
                        }
                    }
                }
        );

        output.start();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            Thread filling = new Thread(
                    () -> {
                        String str = generateRoute("RLRFR", 100);

                        char[] arr = str.toCharArray();

                        int count = 0;
                        for (char ch : arr) {
                            if (ch == 'R') {
                                count++;
                            }
                        }

                        synchronized (sizeToFreq) {
                            if (sizeToFreq.containsKey(count)) {
                                sizeToFreq.put(count, sizeToFreq.get(count) + 1);
                            } else {
                                sizeToFreq.put(count, 1);
                            }
                            sizeToFreq.notify();
                        }
                    }
            );
            threads.add(filling);
            filling.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        output.interrupt();
    }
}
