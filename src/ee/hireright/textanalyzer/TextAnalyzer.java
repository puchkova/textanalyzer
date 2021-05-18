package ee.hireright.textanalyzer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextAnalyzer {
    public static void calculateAndPrintNumberOfWordsAndChars(File[] files,
                                                              String[] stopWords,
                                                              boolean capitalLetter,
                                                              boolean characters) throws IOException {
        List<String> result = getAllWords(files);

        if (capitalLetter) {
            result = getWordsStartingWithCapitalLetter(result);
        }
        if (stopWords != null) {
            result = getWordsWithoutStopWords(result, stopWords);
        }
        if (characters) {
            System.out.println(result.size() + " words, " + calculateNumberOfChars(result) + " symbols");
        } else {
            System.out.println(result.size() + " words");
        }
    }

    private static List<String> getAllWords(File[] files) throws IOException {
        StringBuilder d = new StringBuilder();
        for (File file : files) {
            FileInputStream fis = new FileInputStream(file);
            byte[] bytesArray = new byte[(int) file.length()];
            fis.read(bytesArray);
            String s = new String(bytesArray);
            d.append(s).append(" ");
        }
        String[] words = d.toString().split(" ");

        return new ArrayList<>(Arrays.asList(words));
    }

    private static List<String> getWordsWithoutStopWords(List<String> words, String[] stopWords) {
        List<String> newList = new ArrayList<>();
        for (String word : words) {
            newList.add(word.toLowerCase());
        }
        List<String> stopWordsList = new ArrayList<>();
        for (String word : stopWords) {
            stopWordsList.add(word.toLowerCase());
        }
        newList.removeAll(stopWordsList);

        return newList;
    }

    private static List<String> getWordsStartingWithCapitalLetter(List<String> words) {
        List<String> capitalLetterList = new ArrayList<>();
        for (String word : words) {
            if (Character.isUpperCase(word.charAt(0))) {
                capitalLetterList.add(word);
            }
        }
        return capitalLetterList;
    }

    private static int calculateNumberOfChars(List<String> words) {
        String result = words.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        return result.length();
    }
}
