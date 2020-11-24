package fedcleprogrammingassignment;

import java.io.*;
import java.util.*;

/**
 *
 * @author nickm
 */
public class StopWords {
//    public static ArrayList<String> stopWords = new ArrayList<String>();
//    //public static String[] stopWords;
//    InputStream stopWordsStream = FedCleProgrammingAssignment.class.getResourceAsStream("/resources/stopwords.txt");
//    public static ArrayList<String> wordsFromTextList = new ArrayList<String>();
//    
//    public String removeStopWords(InputStream is) throws IOException{
//        String stopWordsString = readInputStreamAsString(stopWordsStream);
//        stopWordsString = stopWordsString.trim().replaceAll("\\s+", " ");
//            //System.out.println("After trim:  " + stopWords);
//            String[] stopWordsSA = stopWordsString.split(" ");
//             for(String word : stopWordsSA) {
//                stopWords.add(word);
//            }
//        //System.out.println(stopWords);
//        String text = readInputStreamAsString(is);
//        text = text.trim().replaceAll("\\s+", " ");
//            System.out.println("After trim:  " + text);
//            String[] words = text.split(" ");
//            
//            for(String word : words) {
//                wordsFromTextList.add(word);
//            }
//                System.out.println("StopWords length = " + stopWords.size());
//            //remove stop words from the ArrayList
//             for(int j = 0; j < stopWords.size(); j++) {
//                if (wordsFromTextList.contains(stopWords.get(j))) {
//                    wordsFromTextList.remove(stopWords.get(j));
//                }
//            }
//             System.out.print("This is the start\n\n\n\n");
//            for(String str : wordsFromTextList) {
//                System.out.print(str + " ");
//            } 
////     
////     
////     
////     
////     
////     
////     }catch(IOException e) {
////            e.printStackTrace();
////     }
//            
//            
//            
//            
//            
//            
//            
//            return null;
//        }
    
    
    //public static ArrayList<String> stopWords = new ArrayList<String>();
    //public static String[] stopWords;
    //public static ArrayList<String> wordsFromTextList = new ArrayList<String>();
    
    public String removeStopWords(String stopWordsString, String text, boolean display) {
        ArrayList<String> stopWords = new ArrayList<>();
        ArrayList<String> wordsFromTextList = new ArrayList<>();
        text = text.toLowerCase().replaceAll("[^\\w']", " ");
       // word = word.replaceAll("[^\\w']", "");
        
        stopWordsString = stopWordsString.trim().replaceAll("\\s+", " ");
        String[] stopWordsSA = stopWordsString.split(" ");
            //System.out.println("After trim:  " + stopWords);
            
           wordsFromTextList.addAll(Arrays.asList(text.split(" ")));
           stopWords.addAll(Arrays.asList(stopWordsSA));
           
           wordsFromTextList.removeAll(stopWords);
           if(display == true){
           System.out.println("\n\n\nAfter Removal"+wordsFromTextList.toString().replace(",",""));
           }
            
//             for(String word : stopWordsSA) {
//                stopWords.add(word);
//            }
        //System.out.println(stopWords);
       // String text = readInputStreamAsString(is);
//        text = text.trim().replaceAll("\\s+", " ");
//            System.out.println("After trim:  " + text);
//            String[] words = text.split(" ");
//            
//            for(String word : words) {
//                wordsFromTextList.add(word);
//            }
//                System.out.println("StopWords length = " + stopWords.size());
            //remove stop words from the ArrayList
//             for(int j = 0; j < stopWords.size(); j++) {
//                if (wordsFromTextList.contains(stopWords.get(j))) {
//                    wordsFromTextList.remove(stopWords.get(j));
//                }
//            }
//             System.out.print("This is the start\n\n\n\n");
//            for(String str : wordsFromTextList) {
//                System.out.print(str + " ");
//            } 
//     
//     
//     
//     
//     
//     
//     }catch(IOException e) {
//            e.printStackTrace();
//     }
            
            
            
            
            
            
            
            return wordsFromTextList.toString().replace(",", "");
        }

    
    

}
