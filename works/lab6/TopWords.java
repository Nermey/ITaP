import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("task1.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Map<String, Integer> wordsCounter = new HashMap<>();
        StringBuilder text = new StringBuilder();
        while(scanner.hasNextLine()) {
            text.append(scanner.nextLine().toLowerCase()).append(" ");
        }
        scanner.close();
        String[] words = text.toString().split(" ");
        for (String word : words) {
            if (wordsCounter.containsKey(word)) {
                wordsCounter.put(word, wordsCounter.get(word) + 1);
            } else {
                wordsCounter.put(word, 1);
            }
        }
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(wordsCounter.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        LinkedList<String> topWords = new LinkedList<>();
        for (int i = list.size() - 1;  i >= list.size() - 10 ; i--) {
            topWords.add(list.get(i).getKey());
        }
        System.out.println(topWords.toString());
    }
}
