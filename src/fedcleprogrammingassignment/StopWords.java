package fedcleprogrammingassignment;

import java.util.*;

public class StopWords {

    public String removeStopWords(String stopWordsString, String text, boolean display) {
        ArrayList<String> stopWords = new ArrayList<>();
        ArrayList<String> wordsFromTextList = new ArrayList<>();

        text = text.toLowerCase().replaceAll("[^\\w']", " ");
        stopWordsString = stopWordsString.trim().replaceAll("\\s+", " ");
        String[] stopWordsSA = stopWordsString.split(" ");

        wordsFromTextList.addAll(Arrays.asList(text.split(" ")));
        stopWords.addAll(Arrays.asList(stopWordsSA));

        wordsFromTextList.removeAll(stopWords);
        if (display == true) {
            System.out.println(wordsFromTextList.toString().replace(",", ""));
        }

        return wordsFromTextList.toString().replace(",", "");
    }

}
