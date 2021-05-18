package ee.hireright.textanalyzer;

import java.io.File;
import java.io.IOException;

import static ee.hireright.textanalyzer.TextAnalyzer.calculateAndPrintNumberOfWordsAndChars;

public class Main {

    public static void main(String[] args) throws IOException {
        File[] file = {new File("data.txt")};
        File[] multipleFiles = {
                new File("data.txt"),
                new File("data2.txt"),
                new File("data3.txt")};
        String[] stopWords = {"brown", "over", "dog"};

        //no flags
        calculateAndPrintNumberOfWordsAndChars(file, null, false, false);
        //characters
        calculateAndPrintNumberOfWordsAndChars(file, null, false, true);
        //stopwords, characters
        calculateAndPrintNumberOfWordsAndChars(file, stopWords, false, true);
        //stopwords, characters, capital letter
        calculateAndPrintNumberOfWordsAndChars(file, stopWords, true, true);
        //multiple files
        calculateAndPrintNumberOfWordsAndChars(multipleFiles, null, false, true);
    }
}

