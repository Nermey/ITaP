import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
public class ShopData {
    private CopyOnWriteArrayList<Product> soldProducts;
    ShopData() {
        soldProducts = new CopyOnWriteArrayList<>();
    }
    public void addNewProduct(String name, float price) {
        soldProducts.add(new Product(name, price));
    }
    public String showAllProducts() {
        String[] products = new String[soldProducts.size()];
        for (int i = 0; i < products.length; i++) {
            products[i] = soldProducts.get(i).getName();
        }
        return Arrays.toString(products);
    }
    public float calculateTotalPrice() {
        float totalPrice = 0;
        for (Product soldProduct : soldProducts) {
            totalPrice += soldProduct.getPrice();
        }
        return totalPrice;
    }
    public String getMostPopularProduct() {
        HashMap<String, Integer> products = new HashMap<>();
        int maxCount = 0;
        String mostPopularProduct= "";
        for (Product product: soldProducts) {
            if (products.containsKey(product.getName())) {
                products.put(product.getName(), products.get(product.getName()) + 1);
                if (maxCount < products.get(product.getName())) {
                    maxCount = products.get(product.getName());
                    mostPopularProduct = product.getName();
                }
            } else {
                products.put(product.getName(), 1);
            }
        }
        return mostPopularProduct;
    }
}
