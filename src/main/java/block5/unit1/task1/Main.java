package block5.unit1.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        List<Future> futures = new ArrayList<>();

        ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        String[] texts = new String[25];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("aab", 30000);
        }

        for (String text : texts) {
            Callable<Integer> callable =
                    () -> {
                        int maxSize = 0;
                        for (int i = 0; i < text.length(); i++) {
                            for (int j = 0; j < text.length(); j++) {
                                if (i >= j) {
                                    continue;
                                }
                                boolean bFound = false;
                                for (int k = i; k < j; k++) {
                                    if (text.charAt(k) == 'b') {
                                        bFound = true;
                                        break;
                                    }
                                }
                                if (!bFound && maxSize < j - i) {
                                    maxSize = j - i;
                                }
                            }
                        }
                        System.out.println(text.substring(0, 100) + " -> " + maxSize);
                        return maxSize;
                    };

            Future<Integer> future = pool.submit(callable);
            futures.add(future);
        }


        Integer finalResult = 0;

        for (Future<Integer> future : futures) {
            if (finalResult < future.get()) {
                finalResult = future.get();
            }
        }

        pool.shutdown();

        System.out.println("finalResult: " + finalResult);
    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }
}
