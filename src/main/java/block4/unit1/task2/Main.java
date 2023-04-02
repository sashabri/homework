package block4.unit1.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static List<Integer> generateList(int input1, int input2) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input1; i++) {
            list.add(random.nextInt(input2));
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Logger logger = Logger.getInstance();

        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.println("Введите размер списка:");
        int input1 = sc.nextInt();
        System.out.println("Введите верхнюю границу для значений:");
        int input2 = sc.nextInt();
        logger.log("Создаём и наполняем список");
        List<Integer> list = generateList(input1, input2);
        System.out.println("Вот случайный список:" + list);
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.println("Введите порог для фильтра:");
        int input3 = sc.nextInt();
        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(input3);
        List<Integer> filterList = filter.filterOut(list);
        logger.log("Прошло фильтр" + filterList.size() + " элемента из " + input1);
        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список:" + filterList);
        logger.log("Завершаем программу");
    }
}
