import java.util.SplittableRandom;

public class Practice3 {

    public static void main(String[] args) {

        System.out.println("task2");
        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));

        System.out.println("task3");
        System.out.println(doesBlockFit(1, 3, 5, 4, 5));
        System.out.println(doesBlockFit(1, 8, 1, 1, 1));
        System.out.println(doesBlockFit(1, 2, 2, 1, 1));

        System.out.println("task4");
        System.out.println(numCheck(243));
        System.out.println(numCheck(52));


    }

    public static String stringTransform(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                str = str.replace(str.substring(i, i + 2), "Double" + String.valueOf(str.charAt(i)).toUpperCase());
            }
        }
        return str;
    }

    public static boolean doesBlockFit(int height, int weight, int depth, int holeHeight, int holeWeight) {
        return Math.min(Math.min(height * weight, height * depth), weight * depth) <= holeWeight * holeHeight;
    }

    public static boolean numCheck(int num) {
        int sum = 0;
        int newNum = num;
        while (newNum >= 1) {
            sum += (int) Math.pow(newNum % 10, 2);
            newNum /= 10;
        }
        return (sum % 2) == (num % 2);
    }
}
