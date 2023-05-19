package block5.unit3;

import java.util.Random;
import java.util.concurrent.*;

public class Main {
    static BlockingQueue<String> queueA = new ArrayBlockingQueue<>(100);
    static BlockingQueue<String> queueB = new ArrayBlockingQueue<>(100);
    static BlockingQueue<String> queueC = new ArrayBlockingQueue<>(100);

    static boolean isFinal = false;

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

    public static FutureTask<String> counterLetter(char letter, BlockingQueue<String> queue) {
        Callable<String> myCallable = () -> {
            String maxLetters = "";
            int countMax = 0;
            while (!isFinal || !queue.isEmpty()) {
                String str = queue.take();
                char[] arr = str.toCharArray();

                int countLetterInSrt = 0;

                for (char let : arr) {
                    if (let == letter) {
                        countLetterInSrt++;
                    }
                }
                if (countMax < countLetterInSrt) {
                    countMax = countLetterInSrt;
                    maxLetters = countMax + " повторений в строке, текст строки - " + str;
                }
            }
            return maxLetters;
        };
        return new FutureTask<>(myCallable);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Thread writer = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                String newStr = generateText("abc", 100000);
                queueA.offer(newStr);
                queueB.offer(newStr);
                queueC.offer(newStr);
            }
            isFinal = true;
        });
        writer.start();

        FutureTask<String> taskA = counterLetter('a', queueA);
        Thread riderA = new Thread(taskA);
        riderA.start();

        FutureTask<String> taskB = counterLetter('b', queueB);
        Thread riderB = new Thread(taskB);
        riderB.start();

        FutureTask<String> taskC = counterLetter('c', queueC);
        Thread riderC = new Thread(taskC);
        riderC.start();

        riderA.join();
        riderB.join();
        riderC.join();

        System.out.println("Строка с максимальным количеством символов - A, " + taskA.get());
        System.out.println("Строка с максимальным количеством символов - B, " + taskB.get());
        System.out.println("Строка с максимальным количеством символов - B, " + taskC.get());
    }
}
