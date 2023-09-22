import java.sql.Array;
import java.util.*;

public class Practice3 {

    public static void main(String[] args) {

        System.out.println("task1");
        System.out.println(replaceVovels("apple"));
        System.out.println(replaceVovels("Even if you did this task not by yourself, you have to understand every single line of code.") );

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

        System.out.println("task5");
        System.out.println(countRoots(new int[] {1, -3, 2}));
        System.out.println(countRoots(new int[] {2, 5, 2}));
        System.out.println(countRoots(new int[] {1, -6, 9}));

        System.out.println("task6");
        System.out.println(salesData(new String[][] {
                {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}
        }));
        System.out.println(salesData(new String[][] {
                {"Fridge", "Shop2", "Shop3"},
                {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Laptop", "Shop3", "Shop4"},
                {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}
        }));


        System.out.println("task7");
        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));

        System.out.println("task8");
        System.out.println(waveForm(new int[] {3, 1, 4, 2, 7, 5}));
        System.out.println(waveForm(new int[] {1, 2, 3, 4, 5}));
        System.out.println(waveForm(new int[] {1, 2, -6, 10, 3}));

        System.out.println("task9");
        System.out.println(commonVovel("Hello world"));
        System.out.println(commonVovel("Actions speak louder than words."));


        System.out.println("task10");
        System.out.println(Arrays.deepToString(dataScience(new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {5, 5, 5, 5, 5},
                {7, 4, 3, 14, 2},
                {1, 0, 11, 10, 1}})));
        System.out.println(Arrays.deepToString(dataScience(new int[][] {
                {6, 4, 19, 0, 0},
                {81, 25, 3, 1, 17},
                {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}
        })));
        }


    public static String replaceVovels(String str) {
        String vovels = "aeiouy";
        str = str.toLowerCase();
        for (int i = 0; i < vovels.length(); i++) {
            str = str.replace(String.valueOf(vovels.charAt(i)), "*");
        }
        return str;
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

    public static int countRoots(int[] coefs) {
        int d = (int)Math.pow(coefs[1], 2) - 4 * coefs[0] * coefs[2];
        if (d < 0) {
            return 0;
        }
        if (d == 0) {
            return 1;
        }
        return 2;
    }

    public static String salesData(String[][] data) {
        LinkedList<String> res = new LinkedList<>();
        HashSet<String> allShops = new HashSet<>();
        for (int line = 0; line < data.length; line++) {
            for (int shopIndex = 1; shopIndex < data[line].length; shopIndex++) {
                allShops.add(data[line][shopIndex]);
            }
        }
        for (int i = 0; i < data.length; i++) {
            HashSet<String> currentShops = new HashSet<>();
            for (int j = 1; j < data[i].length; j++) {
                currentShops.add(data[i][j]);
            }
            if (allShops.equals(currentShops)) {
                res.add(data[i][0]);
            }
        }
        return res.toString();
    }

    public static boolean validSplit(String str) {
        String[] words = str.split(" ");
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].charAt(words[i].length() - 1) != words[i + 1].charAt(0)) {
                return false;
            }
        }
        return true;
    }

    public static boolean waveForm(int[] nums) {
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static String commonVovel(String str) {
        String vovels = "aeiouy";
        str = str.toLowerCase();
        int maxValue = 0;
        char letter = ' ';
        for (int i = 0; i < vovels.length(); i++) {
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (maxValue < count) {
                    maxValue = count;
                    letter = vovels.charAt(i);
                }
                if (vovels.charAt(i) == str.charAt(j)) {
                    count++;
                }


            }
        }
        return String.valueOf(letter);
    }

    public static int[][] dataScience(int[][] ar) {
        int changeIndex = 0;
        for (int line = 0; line < ar.length; line++) {
            float sum = 0;
            for (int i = 0; i < ar.length; i++) { // считать по столбцу а не линиям
                sum += ar[i][changeIndex];
            }
            //System.out.println("sum " + (float)(sum - ar[line][changeIndex]) / (ar.length - 1) + "-> " + Math.round((float) ((sum - ar[line][changeIndex]) / (ar.length - 1))));
            ar[line][changeIndex] = Math.round(((sum - ar[line][changeIndex]) / (ar.length - 1)));
            changeIndex++;
        }
        return ar;
    }
}
