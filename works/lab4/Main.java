import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
            try {
                arr[i] = in.nextInt();
            }
            catch (InputMismatchException exception) {
                System.err.println("указан неверный тип данных");
                i--;
                in.nextLine();
            }
        }
        int sum = 0;
        try {
            int index = 0;
            while (true) {
                sum += arr[index];
                index++;
        }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.err.println("вы вышли за границу массива");
        }
        finally {
            System.out.println(sum / arr.length);
        }
    }
}