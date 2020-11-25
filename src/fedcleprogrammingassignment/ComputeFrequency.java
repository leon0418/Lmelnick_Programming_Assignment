package fedcleprogrammingassignment;

import java.util.*;
import static java.util.stream.Collectors.toMap;

public class ComputeFrequency {

    public void computeFrequency(String inputString, Boolean topTwenty) {

        Map<String, Integer> wordCount = new HashMap<>();

        String line;
        String[] wordArray = inputString.split("[\\s-]+");
        String word;

        int len = wordArray.length;
        Integer count;
        for (int i = 0; i < len; i++) {
            word = wordArray[i].toLowerCase();
            word = word.replaceAll("[^a-zA-Z\\s]", " ");
            word = word.replaceAll("[^\\w]", "");
            count = wordCount.get(word);
            if (count != null) {
                count++;
            } else {
                count = 1;
            }
            if (!word.equals("")) {//filter out empty strings, I'm sure there is a better way to do this with my above regex
                wordCount.put(word, count);
            }
        }

        //section to decide to print all word quantities or give top twenty in descending order
        if (topTwenty) {

            Map<String, Integer> sorted = wordCount.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(20).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
            //Print out the top 20 sorted keys and values
            sorted.forEach((key, value) -> System.out.println(key + " : " + value));

        } else {
            wordCount.forEach((key, value) -> System.out.println(key + " : " + value));
        }
    }
}
