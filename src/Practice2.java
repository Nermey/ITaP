
import java.util.Arrays;
import java.util.Random;


public class Practice2 {
    public static void main(String[] args) {

        System.out.println("task 1");
        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));

        System.out.println("task2");
        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));

        System.out.println("task3");
        System.out.println(differenceEvenOdd(new int[]{44, 32, 86, 19}));
        System.out.println(differenceEvenOdd(new int[]{22, 50, 16, 63, 31, 55}));

        System.out.println("task4");
        System.out.println(equalToAvg(new float[] {1, 2, 3, 4, 5}));
        System.out.println(equalToAvg(new float[] {1, 2, 3, 4, 5, 6}));

        System.out.println("task5");
        for (int i: indexMult(new int[]{1, 2, 3})) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i: indexMult(new int[]{3, 3, -2, 408, 3, 31})) { // ошибка в ответах задания!
            System.out.print(i + " ");
        }

        System.out.println(" ");
        System.out.println("task6");
        System.out.println(reverse("Hello World"));
        System.out.println(reverse("The quick brown fox."));

        System.out.println("task7");
        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11));

        System.out.println("task8");
        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(10));
        System.out.println(pseudoHash(0));

        System.out.println("task9");
        System.out.println(botHelper("Hello, I’m under the water, please help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));

        System.out.println("task10");
        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));


    }

    public static boolean duplicateChars(String a) {
        a = a.toLowerCase();
        for (int i = 0; i < a.length() - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < a.length(); j++) {
                if (a.charAt(i) == a.charAt(j)) {
                    count++;
                }
                if (count == 1) {
                    return true;
                }
            }
        }    return false;
    }
    public static String getInitials(String s) {
        String[] words = s.split(" ");
        String res = "";
        for (String i: words) {
            res += i.charAt(0);
        }
        return res;
    }

    public static int differenceEvenOdd(int[] numbers) {
        int evenSum = 0, oddSum = 0;
        for (int num: numbers) {
            if (num % 2 == 0) {
                evenSum += num;
            }
            else {
                oddSum += num;
            }
        }
        return Math.abs(evenSum - oddSum);
    }

    public static boolean equalToAvg(float[] numbers) {
        float sum = 0;
        for (float num: numbers) {
            sum += num;
        }
        float avg = sum / numbers.length;
        for (float num: numbers) {
            if (num == avg) {
                return true;
            }
        }
        return false;
    }

    public static int[] indexMult(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i] * i;
        }
        return numbers;
    }

    public static String reverse(String str) {
        String res = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            res += str.charAt(i);
        }
        return res;
    }

    public static int Tribonacci(int num) {
        if (num < 3) {
            return 0;
        }
        if (num == 3) {
            return 1;
        }
        return Tribonacci(num - 3) +  Tribonacci(num - 2) + Tribonacci(num - 1);
    }

    public static String pseudoHash(int length) {
        String hash = "";
        Random random = new Random();
        String str = "1234567890";
        for (char ch = 'a'; ch <= 'z' ; ch++) {
            str += String.valueOf(ch);
        }
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(str.length());
            hash += str.charAt(randomIndex);
        }


        return hash;
    }

    public static String botHelper(String str) {
        String[] words = str.split(" ");
        for (String word: words) {
            if (word.startsWith("help")) {
                return "Calling for a staff member";
            }
        }
        return "Keep waiting";
    }

    public static boolean isAnagram(String str1, String str2) {
        char[] str1Chars = str1.toCharArray();
        Arrays.sort(str1Chars);
        char[] str2Chars = str2.toCharArray();
        Arrays.sort(str2Chars);

        return Arrays.equals(str1Chars, str2Chars);
    }


}