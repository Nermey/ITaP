import java.util.SplittableRandom;

public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(isPalindrome(args[i]));
        }

    }

    public static String reverseString(String str) {
        String res = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            res += str.charAt(i);
        }
        return res;
    }

    public static boolean isPalindrome(String str) {
        return str.equals(reverseString(str));
    }
}
