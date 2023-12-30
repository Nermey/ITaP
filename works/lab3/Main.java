import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        HashTable<String, Order> orders = new HashTable<>();

        System.out.println(orders.isEmpty());

        orders.put("1", new Order(new String[]{"french fries", "milkshake"}, 12, "12:00"));

        System.out.println(orders.size());

        orders.put("2", new Order(new String[]{"beef steak", "orange juice"}, 12, "12:51"));

        System.out.println(orders.size());

        System.out.println(orders.getValue("2").orderTime);

        orders.remoteKey("1");
        System.out.println(orders.size());
        System.out.println(orders.getValue("1"));

        orders.put("1", new Order(new String[]{"french fries", "milkshake"}, 12, "12:00"));
        orders.put("3", new Order(new String[]{"french fries", "milkshake"}, 12, "12:00"));
        orders.put("4", new Order(new String[]{"french fries", "milkshake"}, 12, "12:00"));

        orders.put("A", new Order(new String[]{"хинкали", "вода"}, 12, "12:50"));

        orders.put("Q", new Order(new String[]{"суп", "лавандовый раф"}, 12, "12:10"));


        System.out.println(Arrays.toString(orders.view()));

//        for (char i = 1; i <= 200; i++) {
//            if (String.valueOf(i).hashCode() % 16 == "1".hashCode() % 16) {
//                System.out.println(String.valueOf(i));
//
//            }
//        }

    }
}