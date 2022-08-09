
import java.util.Map;

//A main class talks with commentAnalyzer class, which is the base for other classes
// in commentAnalyzer class we have an abstract class called  analyse


public abstract class CommentAnalyzer {
    // public static File commentFile; // this variable is also common for all the classes in the commentAnalyzer class
 //Making it public static makes it accessible to all the classes in the commentAnalyzer class

    //an abstract method to be implemented in the child classes of commentAnalyzer class
    public Map<String, Integer> analyze() {
        return null;
    }

//returns a map of the results of the analysis

    // a method to add the results of the analysis of the file to the total results
    public static void addReportResults(Map<String, Integer> fileResults, Map<String, Integer> totalResults) {
        for (Map.Entry<String, Integer> entry : fileResults.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (totalResults.containsKey(key)) {
                totalResults.put(key, totalResults.get(key) + value);
            } else {
                totalResults.put(key, value);
            }
        }
    }
    

}
