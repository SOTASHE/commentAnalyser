package com.ikhokha.techcheck;

import java.io.File;
// import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		File file = new File("docs");
		File[] files = file.listFiles();
		for (File f : files) {
			if (f.getName().endsWith(".txt")) {
				CommentAnalyzer ca = new CommentAnalyzer(f);
				Map<String, Integer> results = ca.analyze();
				System.out.println(results);
			}
		}
	}
}


