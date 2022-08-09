import java.io.File;
import java.util.HashMap;
import java.util.Map;

class FileRead extends Thread {
        public FileRead(File file, Map<String, Integer> totalResults) 
        { 
        }
              @Override
        public void run() {
            try {
              
                Map<String, Integer> fileResults = new HashMap<>();
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
                        //sum the results of the analysis of the file to the total Results
                        addReportResults(analyzerComments.analyze(), fileResults);
                        addReportResults(analyzerqusetions.analyze(), fileResults);
                        addReportResults(analyzerspam.analyze(), fileResults);

                    }
                }
            } catch (Exception e) {
    e.printStackTrace();
    }
}

    public Map<String, Integer> AnalyzeComments(Comments analyzer) {
        //analyze the comments in the file and return the results in a map
        return analyzer.analyze();
    }
    public Map<String, Integer> AnalyzeQuestions(Questions analyzer) {
        //analyze the questions in the file and return the results in a map
        return analyzer.analyze();
    }
    public Map<String, Integer> AnalyzeSpam(Spam analyzer) {
        //analyze the spam in the file and return the results in a map
        return analyzer.analyze();
    }
    public void addReportResults(Map<String, Integer> fileResults, Map<String, Integer> totalResults) {
        //add the results of the analysis of the file to the total results
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