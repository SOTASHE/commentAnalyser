
import java.util.Map;



public abstract class CommentAnalyzer {
    public  Map<String, Integer> analyze() {
        return null;
    }

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
