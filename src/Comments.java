import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Comments extends CommentAnalyzer { 
    // private File commentFile; // a private File object that will be used to store the file we want to analyze
    private File commentFile; 

	public Comments(File f) { // a constructor that takes a File object as a parameter and stores it in the commentFile variable
		this.commentFile = f;
	}
	
	public Map<String, Integer> analyze() { // a method that returns a map of the comments and their frequencies in the file (the key is the comment and the value is the frequency) and stores it in the results variable

		Map<String, Integer> results = new HashMap<>(); //a new Map object that will be used to store the comments and their frequencies in the file (the key is the comment and the value is the frequency) and pass it to the analyze method and return it to the main method

		try (BufferedReader br = new BufferedReader(new FileReader(commentFile))) { //a new BufferedReader object that will be used to read the file we want to analyze and pass it to the analyze method and return it to the main method	
			String line; // a String variable that will be used to store the line we want to analyze and pass it to the analyze method and return it to the main method
			while ((line = br.readLine()) != null) { // a while loop that will run as long as there is a line in the file we want to analyze and pass it to the analyze method and return it to the main method
				if (line.length() < 15) {
					results.put("Total number of comments that are shorter than 15 characters",
							results.getOrDefault("Total number of comments that are shorter than 15 characters", 0)
									+ 1);
				}
				// - Total number of comments that refer to the "Mover" device
				if (line.contains("Mover")) {
					results.put("Total number of comments that refer to the \"Mover\" device",
							results.getOrDefault("Total number of comments that refer to the \"Mover\" device", 0)
									+ 1);
				}
				//- Total number of comments that refer to the "Shaker" device
				if (line.contains("Shaker")) {
					results.put("Total number of comments that refer to the \"Shaker\" device",
							results.getOrDefault("Total number of comments that refer to the \"Shaker\" device", 0)
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
