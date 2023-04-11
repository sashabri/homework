package block4.unit4;

import java.util.ArrayList;
import java.util.List;
//принцип единственной ответственности (Single Responsibility Principle)
public class Basket {

    private List<Product> presentShoppingList = new ArrayList<>();

    public void addProducts(Product product, int count) {
        for (int i = 0; i < count; i++) {
            presentShoppingList.add(product);
        }
    }

    public void removeProducts(Product product) {
        presentShoppingList.remove(product);
    }

    public void removeAllPresShopList() {
        presentShoppingList = null;
    }

    public int generalPrice() {
        int result = 0;
        for (Product product : presentShoppingList) {
            result += product.getPrice();
        }
        return result;
    }
    public void printPresentShoppingList() {
        if (presentShoppingList != null) {
            for (Product product : presentShoppingList)
            System.out.println(product.printProduct());
        }
    }
}
