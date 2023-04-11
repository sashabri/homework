package block4.unit4;

public class Product {
    private String name;
    private int number;
    private int price;
    private String category;

    public Product(String name, int number, int price, String category) {
        this.name = name;
        this.number = number;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String printProduct() {
        return "(наименование - " + name +
                ") (номер - " + number +
                ") (стоимость - " + price +
                ") (категория - " + category + ")";
    }

}
