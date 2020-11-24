package fedcleprogrammingassignment;

import java.io.*;



/**
 *
 * @author nickm
 */
public class RemoveNonAlphabetical {
  public void removeNonAlphabetical(InputStream is){
    //InputStream is = FedCleProgrammingAssignment.class.getResourceAsStream("/resources/stopwords.txt");

   try(BufferedReader reader = new BufferedReader(new InputStreamReader(is));){
//       try (FileReader reader = new FileReader("/resources/Text1.txt")) {
    //int character;
    String s;
      while((s = reader.readLine()) != null) {
    //while ((character = reader.read()) != -1) {
        //str = str.replaceAll("[^a-zA-Z0-9]", " ");
        //System.out.print((char) character);
        s = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
        System.out.println((String) s);
    }
   } catch (IOException e) {
    e.printStackTrace();
     }
   }
}
