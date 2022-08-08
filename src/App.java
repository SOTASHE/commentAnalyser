import java.io.File;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        File file = new File("docs"); // create a new file object with the path to the directory we want to analyzed
        File[] files = file.listFiles(); // create an array of files from the directory we want to analyze
        for (File f : files) { // loop through the files in the directory
            if (f.getName().endsWith(".txt")) { // if the file is a text file (.txt) we want to analyze we create a new CommentAnalyzer object with the file we want to analyze
                AnalyzeComments(new Comments(f));
                 AnalyzeQuestions(new Questions(f));
                AnalyzeSpam(new Spam(f));
                Comments analyzerComments;
                Questions analyzerqusetions;
                Spam analyzerspam;
                  

                analyzerComments = new Comments(f);
                analyzerqusetions = new Questions(f);
                analyzerspam = new Spam(f);
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
            }
        }
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
