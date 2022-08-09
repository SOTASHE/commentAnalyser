

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        try {
            FileRead fileRead = new FileRead(null, null);

            //initialize the thread  class variables
            Thread t1 = new Thread(fileRead);
            t1.start(); // start the thread

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
   
}