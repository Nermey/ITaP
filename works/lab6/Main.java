

public class Main {
    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack<>(10);
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        System.out.println(stack.pop());
//        System.out.println(stack.peek());
//        stack.push(4);
//        System.out.println(stack.pop());

        ShopData shopData = new ShopData();
        shopData.addNewProduct("Milk", 1);
        shopData.addNewProduct("Chocopie", 2);
        shopData.addNewProduct("Oreo", 3);
        shopData.addNewProduct("Rise", 4);
        shopData.addNewProduct("Rise", 3);
        shopData.addNewProduct("Rise", 3.5f);
        shopData.addNewProduct("bag", 0.5f);
        System.out.println(shopData.showAllProducts());
        System.out.println(shopData.calculateTotalPrice());
        System.out.println(shopData.getMostPopularProduct());
    }
}