package com.ikhokha.techcheck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommentAnalyzer {
 // loop through the files in the directory 
// - Total number of comments that are shorter than 15 characters
//- Total number of comments that refer to the "Mover" device
// - Total number of comments that refer to the "Shaker" device

private File commentFile;

public CommentAnalyzer(File commentFile) {
	this.commentFile = commentFile;
}
	
	public Map<String, Integer> analyze() {
		Map<String, Integer> results = new HashMap<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(commentFile))) {
			// - Total number of comments that are shorter than 15 characters
			String line;
			while ((line = br.readLine()) != null) {
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
