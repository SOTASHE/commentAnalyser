import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Questions extends CommentAnalyzer {
    
  private File commentFile; // a private File object that will be used to store the file we want to analyze
    
	public Questions(File f) { // a constructor that takes a File object as a parameter and stores it in the commentFile variable
		this.commentFile = f;
	}

    @Override  // so we need to override the abstract method in the parent class according to the child class's implementation
    public Map<String, Integer> analyze() {
        // displays a count of comments that contain one or more question marks "?"
        Map<String, Integer> results = new HashMap<>();
        results.put("Total number of comments that contain one or more question marks \"?\"", 0);

        try (BufferedReader br = new BufferedReader(new FileReader(commentFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("?")) {
                    results.put("Total number of comments that contain one or more question marks \"?\"",
                            results.getOrDefault("Total number of comments that contain one or more question marks \"?\"", 0)
                                    + 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;


    }
    
}
