
import java.util.Map;

//A main class talks with commentAnalyzer class, which is the base for other classes
// in commentAnalyzer class we have an abstract class called  analyse


public abstract class CommentAnalyzer {
    // public static File commentFile; // this variable is also common for all the classes in the commentAnalyzer class
 //Making it public static makes it accessible to all the classes in the commentAnalyzer class

    //an abstract method to be implemented in the child classes of commentAnalyzer class
    public abstract Map<String, Integer> analyze();
	


}
