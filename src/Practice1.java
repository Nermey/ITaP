
public class Practice1 {
    public static void main(String[] args) {

        System.out.println("task1:");
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));

        System.out.println("task2:");
        System.out.println(fitCalc((short) 15, (byte) 1));
        System.out.println(fitCalc((short) 24, (byte) 2));
        System.out.println(fitCalc((short) 41, (byte) 3));

        System.out.println("task3:");
        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));

        System.out.println("task4");
        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1));

        System.out.println("task5");
        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));

        System.out.println("task6");
        System.out.println(howManyItems(22, 1.4f, 2));
        System.out.println(howManyItems(45, 1.8f, 1.9f));
        System.out.println(howManyItems(100, 2, 2));

        System.out.println("task7");
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));

        System.out.println("task8");
        System.out.println(gcd(48, 18));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));

        System.out.println("task9");
        System.out.println(ticketSeller(70, 1500));
        System.out.println(ticketSeller(24, 950));
        System.out.println(ticketSeller(53, 1250));

        System.out.println("task10");
        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));


        }

    public static double convert(int gallon) { // task1
        return gallon * 3.785;
    }

    public static int fitCalc(short min, byte intensive) { // task2
        if (intensive >= 1 && intensive <= 3) {
            return min * intensive;
        }
        return 0;
    }

    public static int containers(int box, int bag, int barrel) { // task3
        return box * 20 + bag * 50 + barrel * 100;
    }

    public static String triangleType(int x, int y, int z) { // task4
        int max = Math.max(x, Math.max(y, z));
        if (max > (x + y + z) - max) {
            return "not a triangle";
        }
        if (x == y && y == z) {
            return "isosceles";
        }

        if (x != y && y != z && x != z) {
            return "different-sided";
        }
        return "equilateral";
    }

    public static int ternaryEvaluation(int num1, int num2) {
        return num1 > num2? num1: num2;
    }

    public  static int howManyItems(float n, float w, float h) {
        return (int) (n / 2 / w / h);
    }

    public static int factorial(int num) {
        int res = 1;
        for (int i = 1; i <= num; i++) {
            res *= i;
        }
        return res;
    }

    public static int gcd(int num1, int num2) {
        for (int i = Math.min(num1, num2); i > 0; i--) {
            if (num1 % i == 0 && num2 % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public static int ticketSeller(int concertPlace, int cost) { // неккоретная формулировка по идее нужно возвращать float или указать округление в формулировке
        return Math.round(concertPlace * cost * 0.72f);  // последнее процент комиссии
    }


    public static int tables(int students, int table) {
        int dificit = 0;
        while (students > (table + dificit) * 2)
        {
            dificit++;
        }
        return dificit;
    }
}