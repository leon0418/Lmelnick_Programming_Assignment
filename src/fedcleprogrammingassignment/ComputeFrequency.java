/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fedcleprogrammingassignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import static java.util.stream.Collectors.toMap;

/**
 *
 * @author nickm
 */
public class ComputeFrequency {
    public void computeFrequency(InputStream is, Boolean topTwenty){
    
   Map<String,Integer> wordCount = new HashMap<>();
   try(BufferedReader reader = new BufferedReader(new InputStreamReader(is));){
//       try (FileReader reader = new FileReader("/resources/Text1.txt")) {
    //int character;
    String line;
    String[] wordArray;
    String word;
    while((line = reader.readLine()) != null) {
        //wordArray = line.split("\\s");
        wordArray = line.split("\\b");
          
          //(?=.*\w)^(\w|')+$
        //String countedWords = wordArray.toString();
          int len = wordArray.length;
          Integer count;// = words.get(word);
          for (int i = 0; i < len; i++) {
                word = wordArray[i].toLowerCase();//.replaceAll(((?=.*\w)^(\w|')+$),"");
                word = word.replaceAll(".*(?=\\b\\w|\\W)", "");
            count = wordCount.get(word);
            if(count != null){
               count++; }else{
               count=1;}
               wordCount.put(word, count);
            
          }
    }
   } catch (IOException e) {
    e.printStackTrace();
     }
   //section to decide to print all word quantities or give top twenty in descending order
   if(topTwenty){
       // Map<String, String> m = yourMethodToGetYourMap();
       Map<String, Integer> sorted =  wordCount.entrySet() .stream() .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(20) .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
            //Print out the top 20 sorted keys and values
            sorted.forEach((key, value) -> System.out.println(key + " : " + value));
            
   
   
   }else{
        wordCount.forEach((key, value) -> System.out.println(key + " : " + value));
   }
   }
}
