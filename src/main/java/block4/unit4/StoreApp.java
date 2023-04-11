package block4.unit4;

import block4.unit4.users.AdminImpl;
import block4.unit4.users.User;
import block4.unit4.users.UserImpl;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StoreApp {
    private static final Scanner SCANNER = new Scanner(System.in);
    static final int START_MONEY = 2000; //принцип избегания магических чисел

    private final Set<User> usersSet = new HashSet<>();
    private final Storage storage = new Storage();

    public StoreApp() {
        usersSet.add(new UserImpl("Петя", START_MONEY));
        usersSet.add(new AdminImpl("Федя"));
    }

    private User getShopperOnline(int userId) {
        for (User user : usersSet) {
            if (user.getId() == userId)
                return user;
        }
        return null;
    }

    public void welcome() {
        System.out.println("Добро пожаловать в наш магазин - У Глаши");
    }

   // принцип инверсии зависимостей (Dependency Inversion Principle), в методе аторизации используются интерфейсы.
    public User authorization() {

        System.out.println(
                "Перед совершением покупок необходимо авторизоваться \n" +
                        "Введите имя : "
        );

        String inputName = SCANNER.nextLine();

        for (User user : usersSet) {
            if (user.getName().equals(inputName))
                return user;
        }

        return null;

    }

    public void fillTheBasket(int userId) {

        UserImpl presentShopper = (UserImpl) getShopperOnline(userId);

        System.out.println("Инструкция по заполнению корзины: \n" +
                "Чтобы выбрать категорию товара, введите слово - категория \n" +
                "Поcле вы увидете список категорий, для выбора категории введите название категории, пример - \"бакалея\" \n" +
                "После выбора категории, вы увидите список товаров этой категории \n" +
                "Для добавления товара введите слово \" добавить \", Enter (перенос строки) , \n" +
                "и далее в следующей строке номер товара и количество товара через запятую пример - \n добавить \n 5,4 \n" +
                "Повторяйте это действие столько раз сколько товаров вам необходимо добавить \n" +
                "Чтобы вернуться к выбору категории введите слово категория или сразу название нужной категории \n" +
                "Чтобы завершить наполнение корзины введите слово - \"стоп\""
        );

        String input = SCANNER.nextLine();
        String lastCategory = null;

        while (!input.equals("стоп")) {

            if (input.equals("категория")) {
                storage.printAllCategory();
            }

            if (storage.containsCategoryByName(input)) {
                storage.printOneCategoryProducts(input);
                lastCategory = input;
            }

            if (input.equals("добавить")) {
                String addProduct = SCANNER.nextLine();
                String[] str = addProduct.split(",");
                assert presentShopper != null;
                presentShopper.getMyBasket().addProducts(
                        storage.getProductByNumberAndCategory(Integer.parseInt(str[0]), lastCategory),
                        Integer.parseInt(str[1])
                );
            }
            input = SCANNER.nextLine();
        }
    }

    public void payment(int userId) {
        UserImpl presentUserImpl = (UserImpl) getShopperOnline(userId);

        System.out.println("Список ваших товаров " + presentUserImpl.getName() + " : ");

        presentUserImpl.getMyBasket().printPresentShoppingList();

        System.out.println("\"Итого стоимость покупок составляет - " + presentUserImpl.getMyBasket().generalPrice());

        if (presentUserImpl.getMoney() < presentUserImpl.getMyBasket().generalPrice()) {
            System.out.println(
                    "Упс, кажется вам не хватает средств для оплаты. \n" +
                            "Ведите - 1, если хотете дополнить средства. " +
                            "Ведите - 2, если хотете убрать товар \n " 
            );


            switch (SCANNER.nextInt()) {
                case 1 :
                    System.out.println("Введите сумму - ");
                    presentUserImpl.depositMoney(SCANNER.nextInt());
                    break;
                case 2 :
                    System.out.println("Для удаления введите номер и категорию товара через пробел, пример - напитки 5");
                    String inputDelete = SCANNER.nextLine();
                    String[] arr = inputDelete.split(" ");
                    presentUserImpl.getMyBasket().removeProducts(storage.getProductByNumberAndCategory(Integer.parseInt(arr[1]), arr[0]));
                    break;
            }

            payment(userId);
        } else {
            presentUserImpl.buyFood();
            presentUserImpl.getMyBasket().removeAllPresShopList();
            System.out.println("Оплата прошла успешно.");
        }
    }
}
