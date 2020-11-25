package fedcleprogrammingassignment;

public class RemoveNonAlpha {

    public void removeNonAlphabetical(String inputString) {

        String outputString;

        outputString = inputString.replaceAll("[^a-zA-Z\\s]", "");
        System.out.println((String) outputString);

    }
}
