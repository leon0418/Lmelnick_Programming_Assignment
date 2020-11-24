package fedcleprogrammingassignment;

import java.io.*; 
import java.util.*;


/**
 *
 * @author nickm
 */
public class FedCleProgrammingAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        while(true){
        //Section to choose which file to act on
        Scanner scanner = new Scanner(System.in);// Using Scanner for Getting file choice input from User
        int fileChoice;
        InputStream is = null;
        boolean done = false;
        while (!done) {
        try {
        System.out.println("\nPlease choose which file you would like to work with:");
        System.out.println("Enter 1 for Declaration of Independence");
        System.out.println("Enter 2 for Alice in Wonderland");
        System.out.println("Enter 3 to quit.\n");
        
        fileChoice = scanner.nextInt();
            if(fileChoice == 3){
                System.out.println("Exiting...");
                System.exit(0);
            }
            else if(fileChoice == 1) {
            is = FedCleProgrammingAssignment.class.getResourceAsStream("/resources/Text1.txt");
            done = true;
            }else if(fileChoice == 2) {
            is = FedCleProgrammingAssignment.class.getResourceAsStream("/resources/Text2.txt");
            done = true;
            }else{
                System.out.println("\tInvalid input");
            }
        }
        catch (InputMismatchException e) {
                System.out.println("\tInvalid input");
                scanner.next();  // Clear invalid input from scanner buffer.
        }
    }
    scanner.reset();
        
        
   //Section to decide what action to take on the chosen file
    //Scanner actionChooser = scanner;//new Scanner(System.in);// Using Scanner for Getting action choice input from User
    int actionChoice;
    boolean complete = false;
    while (!complete) {
        try {
        System.out.println("Please choose action you would like to take on the chosen file");
        System.out.println("Enter 1 to remove stop words");
        System.out.println("Enter 2 to remove all non-alphabetical text");
        System.out.println("Enter 3 to stem words into their root form");
        System.out.println("Enter 4 to compute the frequency of each word");
        System.out.println("Enter 5 to display the 20 most commonly appearing terms in decending order");
        System.out.println("Enter 6 to quit.\n");
        
        actionChoice = scanner.nextInt();
        switch(actionChoice) {
            case 1:
                System.out.println("Case 1");
                //Stop Words Section
                StopWords sw =new StopWords();
                sw.removeStopWords(is);
                complete = true;
                break;
            case 2:
                System.out.println("Case 2");
                //Remove Non-alphabetical section
                RemoveNonAlphabeticalStatic rna = new RemoveNonAlphabeticalStatic();
                rna.removeNonAlphabetical(is);
                complete = true;
                break;
            case 3:
                System.out.println("Case 3");
                complete = true;
                break;
                case 4:
                System.out.println("Case 4");
                 //Word Frequency Section
                ComputeFrequency cf = new ComputeFrequency();
                cf.computeFrequency(is, false);//pass the InputStream and that this is not a top twenty count
                complete = true;
                break;
            case 5:
                System.out.println("Case 5");
                //Top 20 Section
                ComputeFrequency cfTopTwenty = new ComputeFrequency();
                cfTopTwenty.computeFrequency(is, true);//pass the InputStream and that this is a top twenty count
                complete = true;
                break;
            case 6:
                System.out.println("Exiting...");
                //Exit Section
                System.exit(0);
                break;
                default:
                System.out.println("\tInvalid input");
        }
        }
        catch(InputMismatchException e){
            System.out.println("\tInvalid input");
            scanner.next();
        };
        
        }
    //actionChooser.close();
    //actionChooser.remove();
    scanner.reset();
    }
  }
}