package block4.unit4;

import java.util.*;

public class Storage {

    static final int START_COUNT_PRODUCTS = 5;

    private final Map<String, List<Product>> allProducts;

    Storage() {

        this.allProducts = new HashMap<>();

        String[] startCategories = {
                "молочные продукты",
                "бакалея",
                "мясные продукты",
                "фрукты",
                "овощи",
                "напитки",
                "чай",
                "кофе",
                "сладкое",
                "закуски"
        };

        String[] startListProduct = {
                "молоко", "сыр", "йогурт", "сметана", "творог",
                "батон", "ржаной хлеб", "булка", "багет", "кекс",
                "колбаса", "сосиски", "нарезка", "котлеты", "мясо птицы",
                "яблоки", "бананы", "киви", "апельсины", "виноград",
                "картофель", "морковь", "лук", "свёкла", "чеснок",
                "вода", "сок", "морс", "газировка", "минеральная вода",
                "чётрный", "зелёный", "каркаде", "травяной", "пуэр",
                "американо", "капучино", "латте", "раф", "кофетюр",
                "сушки", "кофеты", "шоколад", "пряники", "печенье",
                "чипсы", "сухарики", "солёный арахис", "попкорн", "начос"
        };

        int countListProducts = 0;

        for (String startCategory : startCategories) {
            List<Product> products = new ArrayList<>();

            for (int j = 1; j <= START_COUNT_PRODUCTS; j++) {
                products.add(generateProduct(startListProduct[countListProducts], j, startCategory));
                countListProducts++;
            }
            allProducts.put(startCategory, products);
        }
    }

    public void printAllCategory() {
        for (String key : allProducts.keySet()) {
            System.out.println(key);
        }
    }

    public void printOneCategoryProducts(String category) {
        List<Product> printList = allProducts.get(category);
        for (Product product : printList) {
            System.out.println(product.printProduct());
        }
    }


    public boolean containsCategoryByName(String category) {
        return allProducts.containsKey(category);
    }


    public Product generateProduct(String name, int number, String category) {
        return new Product(name, number, (int) (50 + Math.random() * 101), category);
    }

    public Product getProductByNumberAndCategory(int number, String category) {
        Product result = null;
        for (String categor : allProducts.keySet()) {
            if (categor.equals(category)) {
                for (Product product : allProducts.get(categor)) {
                    if (product.getNumber() == number) {
                        result = product;
                    }
                }
            }
        }
        return result;
    }
}
