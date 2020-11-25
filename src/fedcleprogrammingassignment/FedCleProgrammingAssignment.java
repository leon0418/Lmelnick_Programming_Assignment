package fedcleprogrammingassignment;

import java.io.*;
import java.util.*;

public class FedCleProgrammingAssignment {

    public static void main(String[] args) throws Exception {
        while (true) {
            //Section to choose which file to act on
            Scanner scanner = new Scanner(System.in);// Using Scanner for Getting file choice input from User
            int fileChoice;
            InputStream is = null;
            boolean done = false;
            while (!done) {
                try {
                    System.out.println("\nPlease choose which file you would like to work with:\n");
                    System.out.println("Enter 1 for Declaration of Independence");
                    System.out.println("Enter 2 for Alice in Wonderland");
                    System.out.println("Enter 3 to quit.\n");

                    fileChoice = scanner.nextInt();
                    if (fileChoice == 3) {
                        System.out.println("Exiting...");
                        System.exit(0);
                    } else if (fileChoice == 1) {
                        is = FedCleProgrammingAssignment.class.getResourceAsStream("/resources/Text1.txt");
                        done = true;
                    } else if (fileChoice == 2) {
                        is = FedCleProgrammingAssignment.class.getResourceAsStream("/resources/Text2.txt");
                        done = true;
                    } else {
                        System.out.println("\tInvalid input");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\tInvalid input");
                    scanner.next();  // Clear invalid input from scanner buffer.
                }
            }
            scanner.reset();

            //Section to decide what action to take on the chosen file
            int actionChoice;
            boolean complete = false;
            while (!complete) {
                try {
                    System.out.println("\nPlease choose action you would like to take on the chosen file:\n");
                    System.out.println("Enter 1 to remove stop words");
                    System.out.println("Enter 2 to remove all non-alphabetical text");
                    System.out.println("Enter 3 to stem words into their root form");
                    System.out.println("Enter 4 to compute the frequency of each word");
                    System.out.println("Enter 5 to display the 20 most commonly appearing terms in decending order");
                    System.out.println("Enter 6 to quit.\n");

                    actionChoice = scanner.nextInt();
                    switch (actionChoice) {
                        case 1:
                            System.out.println("\n\nYou chose to remove stop words:\n\n");
                            //Stop Words Section
                            InputStream stopWordsStream = FedCleProgrammingAssignment.class.getResourceAsStream("/resources/stopwords.txt");
                            InputStreamToStringConverter stopWordsConverter = new InputStreamToStringConverter();
                            String stopWordsInput = stopWordsConverter.convertInputStreamToString(stopWordsStream);
                            InputStreamToStringConverter stopWordsTextConverter = new InputStreamToStringConverter();
                            String stopWordsTextInput = stopWordsTextConverter.convertInputStreamToString(is);
                            StopWords sw = new StopWords();
                            sw.removeStopWords(stopWordsInput, stopWordsTextInput, true);
                            stopWordsStream.close();
                            is.close();
                            complete = true;
                            break;
                        case 2:
                            System.out.println("\n\nYou chose to remove all non-alphabetical characters:\n\n");
                            //Remove Non-alphabetical section
                            InputStreamToStringConverter nonAlphaConverter = new InputStreamToStringConverter();
                            String nonAlphaInput = nonAlphaConverter.convertInputStreamToString(is);
                            RemoveNonAlpha rna = new RemoveNonAlpha();
                            rna.removeNonAlphabetical(nonAlphaInput);
                            is.close();
                            complete = true;
                            break;

                        case 3:
                            //Stemming section
                            System.out.println("\n\nYou chose to stem words into their root form:\n\n");
                            char[] w = new char[501];
                            Stemmer s = new Stemmer();

                            try {
                                try {
                                    while (true) {
                                        int ch = is.read();
                                        if (Character.isLetter((char) ch)) {
                                            int j = 0;
                                            while (true) {
                                                ch = Character.toLowerCase((char) ch);
                                                w[j] = (char) ch;
                                                if (j < 500) {
                                                    j++;
                                                }
                                                ch = is.read();
                                                if (!Character.isLetter((char) ch)) {
                                                    /* to test add(char ch) */
                                                    for (int c = 0; c < j; c++) {
                                                        s.add(w[c]);
                                                    }

                                                    /* or, to test add(char[] w, int j) */
 /* s.add(w, j); */
                                                    s.stem();
                                                    {
                                                        String u;

                                                        /* and now, to test toString() : */
                                                        u = s.toString();

                                                        /* to test getResultBuffer(), getResultLength() : */
                                                        /* u = new String(s.getResultBuffer(), 0, s.getResultLength()); */
                                                        System.out.print(u);
                                                    }
                                                    break;
                                                }
                                            }
                                        }
                                        if (ch < 0) {
                                            break;
                                        }
                                        System.out.print((char) ch);
                                    }
                                } catch (IOException e) {
                                    System.out.println("Something went wrong");
                                    break;
                                }
                            } catch (Exception e)//FileNotFoundException e)
                            {
                                System.out.println("Something went wrong");
                                break;
                            }
                            complete = true;
                            break;
                        case 4:
                            System.out.println("\n\nYou chose to compute the frequency of each word:\n\n");
                            //Word Frequency Section
                            InputStreamToStringConverter wordFreqConverter = new InputStreamToStringConverter();
                            String wordFreqInput = wordFreqConverter.convertInputStreamToString(is);
                            ComputeFrequency cf = new ComputeFrequency();
                            cf.computeFrequency(wordFreqInput, false);//pass the String and that this is not a top twenty count
                            is.close();
                            complete = true;
                            break;
                        case 5:
                            System.out.println("\n\nYou chose to display the 20 most commonly appearing terms in decending order:\n\n");
                            //Top 20 Section
                            InputStream ttstopWordsStream = FedCleProgrammingAssignment.class.getResourceAsStream("/resources/stopwords.txt");
                            InputStreamToStringConverter ttstopWordsConverter = new InputStreamToStringConverter();
                            String ttstopWordsInput = ttstopWordsConverter.convertInputStreamToString(ttstopWordsStream);
                            //Get the text for both methods
                            InputStreamToStringConverter topTwentyConverter = new InputStreamToStringConverter();
                            String topTwentyInput = topTwentyConverter.convertInputStreamToString(is);
                            //Now put text through the StopWords method with the display flag false so the text is not shown
                            StopWords ttsw = new StopWords();
                            topTwentyInput = ttsw.removeStopWords(ttstopWordsInput, topTwentyInput, false);
                            //Now compute Top Twenty without the stop words
                            ComputeFrequency cfTopTwenty = new ComputeFrequency();
                            cfTopTwenty.computeFrequency(topTwentyInput, true);//pass the String and that this is a top twenty count
                            is.close();
                            complete = true;
                            break;
                        case 6:
                            System.out.println("Exiting...");
                            //Exit Section
                            System.exit(0);
                        default:
                            System.out.println("\tInvalid input");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\tInvalid input");
                    scanner.next();
                }

            }
            scanner.reset();
        }
    }
}
