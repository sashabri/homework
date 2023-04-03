package block4.unit2.task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinOps bins = new BinOps();

        System.out.println("Введите первое число");
        int input = sc.nextInt();
        System.out.println("Введите второе число");
        int input2 = sc.nextInt();

        String inputToStr1 = Integer.toBinaryString(input);
        String inputToStr2 = Integer.toBinaryString(input2);

        while (true) {
            System.out.println("Вы бререте действие : \n - если вы хотите умножить введите - 1 \n - если вы хотите сложить числа введите - 2");
            int input3 = sc.nextInt();

            if (input3 == 1) {
                System.out.println("Ваш результат в двоичной системе исчесления - \n" + bins.mult(inputToStr1, inputToStr2));
                break;
            }

            if (input3 == 2) {
                System.out.println("Ваш результат в двоичной системе исчесления - \n" + bins.sum(inputToStr1, inputToStr2));
                break;
            } else {
                System.out.println("НЕ КОРРЕКТЫЙ ВВОД");
            }
        }
    }
}
