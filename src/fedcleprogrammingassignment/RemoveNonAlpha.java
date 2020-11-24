package fedcleprogrammingassignment;

import java.io.*;

/**
 *
 * @author nickm
 */
public class RemoveNonAlpha {
//    public static String removeNonAlphabetical(String st){
//    //InputStream is = FedCleProgrammingAssignment.class.getResourceAsStream("/resources/stopwords.txt");
//
//   //try(BufferedReader reader = new BufferedReader(new InputStreamReader(is));){
////       try (FileReader reader = new FileReader("/resources/Text1.txt")) {
//    //int character;
//    String str = null;
//    while(st != null) {
//    //while ((character = reader.read()) != -1) {
//        //str = str.replaceAll("[^a-zA-Z0-9]", " ");
//        //System.out.print((char) character);
//        str = st.replaceAll("[^a-zA-Z']", " ").toLowerCase();
//        //str = st.replaceAll(".*(?=\\b\\w|\\W)", "").toLowerCase();
//        //System.out.println((String) st);
//        st = null;
//    }//}else{str="";}
//    return str;
////   } catch (IOException e) {
////    e.printStackTrace();
////     }
//}  
//    public  void removeNonAlphabetical(InputStream is)throws Exception{
//        try(BufferedReader reader = new BufferedReader(new InputStreamReader(is));){
//                String alphaOnlySt;
//                while((alphaOnlySt = reader.readLine()) != null) {
//                //while((reader.readLine()) != null) {
//                //alphaOnlySt = reader.readLine();
//                alphaOnlySt = alphaOnlySt.replaceAll("[^a-zA-Z']", " ").toLowerCase();
//                //alphaOnlySt = RemoveNonAlphabeticalStatic.removeNonAlphabetical(alphaOnlySt);
//                System.out.println((String) alphaOnlySt);
//                 }
//        }catch(IOException e) {
//            e.printStackTrace();
//        }
//    }
    
     public  void removeNonAlphabetical(String inputString){
        
                String outputString;
                
                outputString = inputString.replaceAll("[^a-zA-Z\\s]", "");//what works
               //outputString = inputString.replaceAll("(')|(\\W)", "$1");//Testing for removing all but apost
                System.out.println((String) outputString);
                 
        
    }
}
