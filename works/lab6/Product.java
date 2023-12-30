public class Product {
    private final float price;
    private final String name;

    Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
}
