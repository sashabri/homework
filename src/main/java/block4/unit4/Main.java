package block4.unit4;

import block4.unit4.users.User;

public class Main {
    public static void main(String[] args) {
        StoreApp storeApp = new StoreApp();
        storeApp.welcome();
        User user = storeApp.authorization();

        if (user == null) {
            System.out.println("Такого пользователя нет.");
        } else {
            switch (user.getRole()) {
                case ADMIN:
                    System.out.println("Функциональность для админа в разработке.");
                    break;
                case SHOPPER:
                    storeApp.fillTheBasket(user.getId());
                    storeApp.payment(user.getId());
                    break;
            }
        }
    }
}
