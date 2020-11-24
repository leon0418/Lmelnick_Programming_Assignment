package fedcleprogrammingassignment;

import java.io.*;
import java.util.*;

/**
 *
 * @author nickm
 */
public class StopWords {
    public static ArrayList<String> stopWords = new ArrayList<String>();
    //public static String[] stopWords;
    InputStream stopWordsStream = FedCleProgrammingAssignment.class.getResourceAsStream("/resources/stopwords.txt");
    public static ArrayList<String> wordsFromTextList = new ArrayList<String>();
    
    public String removeStopWords(InputStream is) throws IOException{
        String stopWordsString = readInputStreamAsString(stopWordsStream);
        stopWordsString = stopWordsString.trim().replaceAll("\\s+", " ");
            //System.out.println("After trim:  " + stopWords);
            String[] stopWordsSA = stopWordsString.split(" ");
             for(String word : stopWordsSA) {
                stopWords.add(word);
            }
        //System.out.println(stopWords);
        String text = readInputStreamAsString(is);
        text = text.trim().replaceAll("\\s+", " ");
            System.out.println("After trim:  " + text);
            String[] words = text.split(" ");
            
            for(String word : words) {
                wordsFromTextList.add(word);
            }
                System.out.println("StopWords length = " + stopWords.size());
            //remove stop words from the ArrayList
             for(int j = 0; j < stopWords.size(); j++) {
                if (wordsFromTextList.contains(stopWords.get(j))) {
                    wordsFromTextList.remove(stopWords.get(j));
                }
            }
             System.out.print("This is the start\n\n\n\n");
            for(String str : wordsFromTextList) {
                System.out.print(str + " ");
            } 
//     
//     
//     
//     
//     
//     
//     }catch(IOException e) {
//            e.printStackTrace();
//     }
            
            
            
            
            
            
            
            return null;
        }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static String readInputStreamAsString(InputStream in)
    throws IOException {

    BufferedInputStream bis = new BufferedInputStream(in);
    ByteArrayOutputStream buf = new ByteArrayOutputStream();
    int result = bis.read();
    while(result != -1) {
      byte b = (byte)result;
      buf.write(b);
      result = bis.read();
    }
    return buf.toString();
}

    
    

}
