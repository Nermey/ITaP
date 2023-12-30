import java.util.*;

public class Pracrice4 {

    public static void main(String[] args) {
        System.out.println("task 1");
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));

        System.out.println("task 2");
        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));

        System.out.println("task 3");
        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));

        System.out.println("task 4");
        System.out.println(alphabeticRow("abcdjuwx"));
        System.out.println(alphabeticRow("klmabzyxw"));
        System.out.println(alphabeticRow("ababc"));

        System.out.println("task 5");
        System.out.println(letterCounter("aaabbcdd"));
        System.out.println(letterCounter("vvvvaajaaaaa"));

        System.out.println("task 6");
        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));
        System.out.println(convertToNum("zero"));


        System.out.println("task 7");
        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("1111111"));
        System.out.println(uniqueSubstring("77897898"));

        System.out.println("task 8");
        System.out.println(shortestWay(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}}));
        System.out.println(shortestWay(new int[][]{
                {2, 7, 3},
                {1, 4, 8},
                {4, 5, 9}}));

        System.out.println("task 9");
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));

        System.out.println("task 10");
        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));


    }

    public static String nonRepeatable(String str) {  // task 1
        if (str.length() == 0) {
            return "";
        }
        ;
        String symbol = String.valueOf(str.charAt(str.length() - 1)); // получение последего символа
        if (str.indexOf(symbol) != str.lastIndexOf(symbol)) {
            symbol = "";
        }
        return nonRepeatable(str.substring(0, str.length() - 1)) + symbol; // в функцию входит строка на 1 элемент короче
    }

    public static LinkedHashSet<StringBuilder> generateBrackets(int count) { // LinkedHashSet сохраняет порядок записи элементов
        LinkedHashSet<StringBuilder> res = new LinkedHashSet<>();
        if (count == 1) {
            res.add(new StringBuilder("()"));
            return res;
        }

        LinkedHashSet<StringBuilder> prevResult = generateBrackets(count - 1); // добавление предыдущих результатов во внутренние скобки
        for (StringBuilder prevGeneration: prevResult) {
            res.add(prevGeneration.insert(0, "(").append(")"));
        }

        for (int i = count - 1; i >= 1; i--) {
            LinkedHashSet<StringBuilder> combinationOfPreviousBrackets1 = generateBrackets(i);
            LinkedHashSet<StringBuilder> combinationOfPreviousBrackets2 = generateBrackets(count - i);
            for (StringBuilder comb1: combinationOfPreviousBrackets1) {
                for (StringBuilder comb2: combinationOfPreviousBrackets2) {
                    if (comb1.length() + comb2.length() == count * 2) { // чтобы не появлялся скобочный мутант
                        res.add(comb1.append(comb2));
                    }

            }

            }
        }
        return res;
    }

    public static String binarySystem(int length) { // task 3
        LinkedList<StringBuilder> res = new LinkedList<>();
        for (int num = 2; num < Math.pow(2, length); num++) {
            StringBuilder binaryNum = new StringBuilder(Integer.toBinaryString(num));
            while (binaryNum.length() < length) { // дополение нулями для необходимой длины
                binaryNum.insert(0, "0");
            }
            if (binaryNum.toString().replace("00", "").length() == binaryNum.length()) { // проверка на соседние нули
                res.add(binaryNum);
            }
        }
        return res.toString();
    }

    public static String alphabeticRow(String str) { // task 4
        String maxLenRow = "";
        for (int i = 0; i < str.length() - 1; i++) {
            StringBuilder currentRow = new StringBuilder(String.valueOf(str.charAt(i)));
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j - 1) + 1 != str.charAt(j) && str.charAt(j - 1) - 1 != str.charAt(j)) { // проверка на то что текущий символ больше или меньше предыдущего по алфавиту
                    break;
                }
                currentRow.append(str.charAt(j));
                if (currentRow.length() > maxLenRow.length()) {
                    maxLenRow = currentRow.toString();
                }
            }
        }
        return maxLenRow;
    }

    public static StringBuilder letterCounter(String str) { // task 5
        StringBuilder res = new StringBuilder();
        ArrayList<String> letters = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) { // добавление символа с его количетсвом
            int maxLength = 1;
            int currentLength = 1;
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) != str.charAt(j)) {
                    break;
                }
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            }
            if (letters.size() >= 1 && letters.get(letters.size() - 1).charAt(0) == str.charAt(i)) { // чтобы не записывать предыдущие результаты
                continue;
            }
            letters.add(String.valueOf(str.charAt(i)) + String.valueOf(maxLength));
        }
        for (int i = 0; i < letters.size(); i++) { // сортировка выбором
            String min = letters.get(i);
            int minId = i;
            for (int j = i + 1; j < letters.size(); j++) {
                if (Integer.parseInt(letters.get(j).substring(1)) < Integer.parseInt(min.substring(1))) {
                    min = letters.get(j);
                    minId = j;
                }
            }
            String temp = letters.get(i);
            letters.set(i, min);
            letters.set(minId, temp);
        }
        for (int i = 0; i < letters.size(); i++) {
            res.append(letters.get(i));
        }
        return res;
    }

    public static int convertToNum(String numExpression) { // task 6
        Map<String, Integer> wordsToNumbers = new HashMap<>();
        wordsToNumbers.put("zero", 0);
        wordsToNumbers.put("one", 1);
        wordsToNumbers.put("two", 2);
        wordsToNumbers.put("three", 3);
        wordsToNumbers.put("four", 4);
        wordsToNumbers.put("five", 5);
        wordsToNumbers.put("six", 6);
        wordsToNumbers.put("seven", 7);
        wordsToNumbers.put("eight", 8);
        wordsToNumbers.put("nine", 9);
        wordsToNumbers.put("ten", 10);
        wordsToNumbers.put("eleven", 11);
        wordsToNumbers.put("twelve", 12);
        wordsToNumbers.put("thirteen", 13);
        wordsToNumbers.put("fifteen", 15);
        wordsToNumbers.put("twenty", 20);
        wordsToNumbers.put("thirty", 30);
        wordsToNumbers.put("fifty", 50);

        String[] words = numExpression.split(" ");
        int res = 0;
        for (String word: words) {
            if (word.endsWith("teen")) {
                res += wordsToNumbers.get(word.substring(0, word.length() - 4)) + 10;
                continue;
            }
            if (word.endsWith("ty") && !wordsToNumbers.containsKey(word)) {
                res += wordsToNumbers.get(word.substring(0, word.length() - 2)) * 10;
                continue;
            }

            if (word.equals("hundred")) {
                res *= 100;
                continue;
            }
            if (word.equals("thousand")) {
                res *= 1000;
                continue;
            }
            res += wordsToNumbers.get(word);
        }
        return res;
    }

    public static StringBuilder uniqueSubstring(String str) { // task 7
        StringBuilder maxLenSubstring = new StringBuilder("");
        for (int i = 0; i < str.length() - 1; i++) {
            StringBuilder currentLength = new StringBuilder(String.valueOf(str.charAt(i))); // добавление 1 символа
            ArrayList<Character> symbolsInSubstring = new ArrayList<>();
            symbolsInSubstring.add(str.charAt(i));
            for (int j = i + 1; j < str.length(); j++) {
                if (symbolsInSubstring.contains(str.charAt(j))) { // проверка на повторение
                    if (maxLenSubstring.length() < currentLength.length()) {
                        maxLenSubstring = currentLength;
                    }
                    break;
                }
                currentLength.append(str.charAt(j)); // добавление если символ прошел проверку
                symbolsInSubstring.add(str.charAt(j));
            }

        }
        return  maxLenSubstring;
    }

    public static int shortestWay(int[][] ar) { // task 8
        for (int i = 1; i < ar.length; i++) { // заполнение краев
            ar[0][i] = ar[0][i - 1] + ar[0][i];
            ar[i][0] = ar[i - 1][0] + ar[i][0];
        }
        for (int i = 1; i < ar.length; i++) {
            for (int j = 1; j < ar.length; j++) {
                ar[i][j] = Math.min(ar[i - 1][j], ar[i][j - 1]) + ar[i][j];
            }
        }
        return ar[ar.length - 1][ar.length - 1];
    }

    public static StringBuilder numericOrder(String str) { // task 9
        String[] words = str.split(" ");
        String[] wordsInCorrectOrder = new String[words.length];
        for (String word: words) {
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                if (Character.isDigit(letter)) {
                    wordsInCorrectOrder[Integer.parseInt(Character.toString(letter)) - 1] = word.replace(Character.toString(letter), "");
                    break;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (String word: wordsInCorrectOrder) {
            res.append(word).append(" ");
        }
        return res;
    }

    public static int switchNums(int num1, int num2) { // task 10
        Integer[] numsToReplace = new Integer[String.valueOf(num1).length()];
        int[] switchNumbers = new int[String.valueOf(num2).length()];

        for (int i = 0; i < numsToReplace.length; i++) { // заполнение массива цифрами числа num1
            numsToReplace[i] = num1 % 10;
            num1/=10;
        }
        Arrays.sort(numsToReplace, Collections.reverseOrder()); // сортировка в обратном порядке
        for (int i = 0; i < switchNumbers.length; i++) {
            switchNumbers[i] = num2 % 10;
            num2/=10;
        }
        int changeIndex = 0;
        for (int i = switchNumbers.length - 1; i >= 0; i--) { // идем в обратном порядке чтобы не переворачивать массив num2
            if (numsToReplace[changeIndex] > switchNumbers[i]) {
                switchNumbers[i] = numsToReplace[changeIndex];
                changeIndex++;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int num: switchNumbers) {
            res.append(num);
        }
        return Integer.parseInt(res.reverse().toString()); // реверсим тк идем динамически
    }
}
