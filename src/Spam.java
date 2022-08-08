import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Spam extends CommentAnalyzer {

     private File commentFile;

    public Spam(File f) { 
		this.commentFile = f;// this is a static variable, so we need to use the class name to access it
	}

    @Override
    public Map<String, Integer> analyze() {
        

  // count lines that contain a url to a web page.
        Map<String, Integer> results = new HashMap<>();
        results.put("Total number of comments that contain a url to a web page", 0);
        try (BufferedReader br = new BufferedReader(new FileReader(commentFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("http")) {
                    results.put("Total number of comments that contain a url to a web page",
                            results.getOrDefault("Total number of comments that contain a url to a web page", 0)
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