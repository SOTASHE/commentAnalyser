import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        //use threads to read the files concurrently and analyze them in parallel using multiple Threads_lock classes and a thread po

        //   process them concurrently using separate threads (ie one thread per file) and then consolidate the results to print the report.
        //         The current code processes the files sequentially. Change the implementation to process them concurrently using separate threads (ie one thread per file) and then consolidate the results to print the report.  
        // call all the classes that implements the analyse method and pass the file as an argument to the constructor of the classes
        // print the results of the analysis in the console output stream using the print method of the Map class and the toString method of the Integer classes

        // code
        // read through all the files in docs directory using threads and process them concurrently using separate threads (ie one thread per file) and then consolidate the results to print the report.
        //         The current code processes the files sequentially. Change the implementation to process them concurrently using separate threads (ie one thread per file) and then consolidate the results to print the report.
        // call all the classes that implements the analyse method and pass the file as an argument to the constructor of the classes
        // print the results of the analysis in the console output stream using the print method of the Map class and the toString method of the Integer Classes

        // code

        // read through all the files in docs directory using threads and process them concurrently using separate threads (ie one thread per file) and then consolidate the results to print the report.
	Map<String, Integer> totalResults = new HashMap<>();
    //Get the list of all files in Array.
        
        File[] files = new File("docs").listFiles();
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("Processing file: " + file.getName());
                  AnalyzeComments(new Comments(file));
                 AnalyzeQuestions(new Questions(file));
                AnalyzeSpam(new Spam(file));
                Comments analyzerComments;
                Questions analyzerqusetions;
                Spam analyzerspam;
                  

                analyzerComments = new Comments(file);
                analyzerqusetions = new Questions(file);
                analyzerspam = new Spam(file);
                //print the results of the analysis
                for (Map.Entry<String, Integer> entry : analyzerComments.analyze().entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
                for (Map.Entry<String, Integer> entry : analyzerqusetions.analyze().entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
                for (Map.Entry<String, Integer> entry : analyzerspam.analyze().entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }

                Thread_lock thread_lock = new Thread_lock(file, totalResults);
                thread_lock.start();
            }
        }
        // wait for all the threads to finish
        for (Thread_lock thread_lock : Thread_lock.threads) {
            thread_lock.join();
        }
        // consolidate the results to print the report.
        for (Thread_lock thread_lock : Thread_lock.threads) {
            totalResults.putAll(thread_lock.results);
        }
        // print the results of the analysis in the console output stream using the print method of the Map class and the toString method of the Integer Classes
        System.out.println(totalResults);
                 




    }


    private static void AnalyzeComments(Comments comments) {
    }

    private static void AnalyzeQuestions(Questions questions) {
    }
    

    private static void AnalyzeSpam(Spam spam) {
    }

    public App(  CommentAnalyzer commentAnalyzer){
        commentAnalyzer.analyze();


    }
    }