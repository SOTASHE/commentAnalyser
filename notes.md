
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

                //sum the results of the analysis of the file to the total Results
                addReportResults(analyzerComments.analyze(), totalResults);
                addReportResults(analyzerqusetions.analyze(), totalResults);
                addReportResults(analyzerspam.analyze(), totalResults);
                addReportResults(totalResults, totalResults);
                //sum up all the results of the analysis of the files to the total Results
                //print the results of the analysis in the console output stream using the print method of the Map class and the toString method of the Integer Classes
                // System.out.println("results for each file:");

            }
            for (Map.Entry<String, Integer> entry : totalResults.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());

                Thread_lock thread_lock = new Thread_lock(file, totalResults);
                thread_lock.start();
            }
        }

        System.out.println(" Total results: ");
        // for (Map.Entry<String, Integer> entry : totalResults.entrySet()) {
        //     System.out.println(entry.getKey() + ": " + entry.getValue());
        // }

        // add results of the analysis of the file to the total results accordibing to each file annd the condtions of the analysis of the file to the total results
        // print the results of the analysis in the console output stream using the print method of the Map class and the toString method of the Integer Classes
       



    }


    private static void AnalyzeComments(Comments comments) {
    }

    private static void AnalyzeQuestions(Questions questions) {
    }
    

    private static void AnalyzeSpam(Spam spam) {
    }

    public App(CommentAnalyzer commentAnalyzer) {
        commentAnalyzer.analyze();

    }
    
private static void addReportResults(Map<String, Integer> source, Map<String, Integer> target) {

		for (Map.Entry<String, Integer> entry : source.entrySet()) {
			target.put(entry.getKey(), entry.getValue());
		}
		
	}






















     //     // read through all the files in docs directory using threads and process them concurrently using separate threads (ie one thread per file) and then consolidate the results to print the report.
    //     Map<String, Integer> totalResults = new HashMap<>();
    //     //Get the list of all files in Array.

    //     File[] files = new File("docs").listFiles();
    //     for (File file : files) {
    //         if (file.isFile()) {
    //             System.out.println("Processing file: " + file.getName());
    //             AnalyzeComments(new Comments(file));
    //             AnalyzeQuestions(new Questions(file));
    //             AnalyzeSpam(new Spam(file));
    //             Comments analyzerComments;
    //             Questions analyzerqusetions;
    //             Spam analyzerspam;

    //             analyzerComments = new Comments(file);
    //             analyzerqusetions = new Questions(file);
    //             analyzerspam = new Spam(file);
    //             //print the results of the analysis
    //             for (Map.Entry<String, Integer> entry : analyzerComments.analyze().entrySet()) {
    //                 System.out.println(entry.getKey() + ": " + entry.getValue());
    //             }
    //             for (Map.Entry<String, Integer> entry : analyzerqusetions.analyze().entrySet()) {
    //                 System.out.println(entry.getKey() + ": " + entry.getValue());
    //             }
    //             for (Map.Entry<String, Integer> entry : analyzerspam.analyze().entrySet()) {
    //                 System.out.println(entry.getKey() + ": " + entry.getValue());
    //             }

    //             //sum the results of the analysis of the file to the total Results
    //             addReportResults(analyzerComments.analyze(), totalResults);
    //             addReportResults(analyzerqusetions.analyze(), totalResults);
    //             addReportResults(analyzerspam.analyze(), totalResults);
    //             addReportResults(totalResults, totalResults);
    //             //sum up all the results of the analysis of the files to the total Results
    //             //print the results of the analysis in the console output stream using the print method of the Map class and the toString method of the Integer Classes
    //             // System.out.println("results for each file:");

    //         }
    //         for (Map.Entry<String, Integer> entry : totalResults.entrySet()) {
    //             System.out.println(entry.getKey() + ": " + entry.getValue());

    //             Thread_lock thread_lock = new Thread_lock(file, totalResults);
    //             thread_lock.start();
    //         }
    //     }

    //     System.out.println(" Total results: ");
    //     // for (Map.Entry<String, Integer> entry : totalResults.entrySet()) {
    //     //     System.out.println(entry.getKey() + ": " + entry.getValue());
    //     // }

    //     // add results of the analysis of the file to the total results accordibing to each file annd the condtions of the analysis of the file to the total results
    //     // print the results of the analysis in the console output stream using the print method of the Map class and the toString method of the Integer Classes
       



    // }


    // private static void AnalyzeComments(Comments comments) {
    // }

    // private static void AnalyzeQuestions(Questions questions) {
    // }
    

    // private static void AnalyzeSpam(Spam spam) {
    // }

    // public App(CommentAnalyzer commentAnalyzer) {
    //     commentAnalyzer.analyze();

    // }
    
    // private static void addReportResults(Map<String, Integer> source, Map<String, Integer> target) {

    //     for (Map.Entry<String, Integer> entry : source.entrySet()) {
    //         target.put(entry.getKey(), entry.getValue());
    //     }

    // }
    
  